package com.services;

import com.dtos.PaymentDto;
import com.dtos.PaymentRequestDto;
import com.dtos.PaymentResponseDto;

import java.util.List;

public interface PaymentService {

    // Effectuer un paiement
    PaymentResponseDto pay(PaymentRequestDto request);

    // Récupérer tous les paiements
    List<PaymentDto> getAllPayments();

    // Récupérer un paiement par ID
    PaymentDto getPayment(Long id);

}