package com.controllers;

import com.dtos.PaymentDto;
import com.dtos.PaymentRequestDto;
import com.dtos.PaymentResponseDto;
import com.services.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	/**
	 * Créer un paiement
	 */
	@PostMapping
	public PaymentResponseDto pay(@RequestBody PaymentRequestDto request){
		return paymentService.pay(request);
	}

	/**
	 * Lister tous les paiements
	 */
	@GetMapping
	public List<PaymentDto> getAllPayments(){
		return paymentService.getAllPayments();
	}

	/**
	 * Récupérer un paiement par ID
	 */
	@GetMapping("/{id}")
	public PaymentDto getPayment(@PathVariable Long id){
		return paymentService.getPayment(id);
	}
}