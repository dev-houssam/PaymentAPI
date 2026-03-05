package com.services.impl;

import com.dtos.PaymentDto;
import com.dtos.PaymentRequestDto;
import com.dtos.PaymentResponseDto;
import com.entities.BankAccount;
import com.entities.Payment;
import com.entities.Transaction;
import com.repositories.BankAccountRepository;
import com.repositories.PaymentRepository;
import com.repositories.TransactionRepository;
import com.services.PaymentService;
import com.mappers.PaymentMapper;
import com.utils.CardValidator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

	private final BankAccountRepository accountRepository;
	private final TransactionRepository transactionRepository;
	private final PaymentRepository paymentRepository;

	private final Random random = new Random();

	@Override
	public PaymentResponseDto pay(PaymentRequestDto request) {

		// Validation du numéro de carte (algorithme de Luhn)
		if(!CardValidator.isValid(request.getCardNumber())){
			throw new RuntimeException("Invalid card number");
		}

		// Recherche du compte bancaire
		BankAccount account = accountRepository
				.findByCardCardNumber(request.getCardNumber())
				.orElseThrow(() -> new RuntimeException("Card not found"));

		// Simulation d'une erreur bancaire (1 paiement sur 6)
		if(random.nextInt(6) == 0){

			Payment failedPayment = Payment.builder()
					.amount((long) request.getAmount())
					.currency("EUR")
					.status("FAILED")
					.createdAt(LocalDateTime.now().toString())
					.build();

			paymentRepository.save(failedPayment);

			return PaymentResponseDto.builder()
					.success(false)
					.message("Bank error - payment refused")
					.build();
		}

		// Vérification du solde
		if(account.getBalance() < request.getAmount()){

			Payment failedPayment = Payment.builder()
					.amount(request.getAmount())
					.currency("EUR")
					.status("FAILED")

					.createdAt(LocalDateTime.now().toString())
					.build();

			paymentRepository.save(failedPayment);

			return PaymentResponseDto.builder()
					.success(false)
					.message("Insufficient funds")
					.build();
		}

		// Débit du compte
		account.setBalance(account.getBalance() - request.getAmount());

		// Création du paiement
		Payment payment = Payment.builder()
				.amount( request.getAmount())
				.currency("EUR")
				.status("SUCCESS")
				.createdAt(LocalDateTime.now().toString())
				.build();

		paymentRepository.save(payment);

		// Création de la transaction bancaire
		Transaction transaction = Transaction.builder()
				.amount(request.getAmount())
				.status("SUCCESS")
				.description(request.getDescription())
				.date(LocalDateTime.now())
				.account(account)
				.build();

		transactionRepository.save(transaction);

		return PaymentResponseDto.builder()
				.success(true)
				.message("Payment successful")
				.transactionId(transaction.getId())
				.build();
	}

	@Override
	public List<PaymentDto> getAllPayments(){

		return paymentRepository.findAll()
				.stream()
				.map(PaymentMapper::toDto)
				.toList();
	}

	@Override
	public PaymentDto getPayment(Long id){

		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Payment not found"));

		return PaymentMapper.toDto(payment);
	}
}