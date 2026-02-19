package com.controllers;

import com.dtos.PaymentDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.PaymentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentServiceImpl paymentService;

	public PaymentController(PaymentServiceImpl paymentService) {
		this.paymentService = paymentService;
	}

	/** 
	 * <p>Get all payments in the system</p>
	 * @return List<PaymentDto>
	 */
	@GetMapping
	public List<PaymentDto> getPayments() {
		return paymentService.getAllPayments();
	}

	/**
	 * Method to get the payment based on the ID
	 */
	@GetMapping("/{id}")
	public PaymentDto getPayment(@PathVariable Long id){
		return paymentService.getPaymentById(id);
	}

	/**
	 * Create a new Payment in the system
	 */
	@PostMapping
	public PaymentDto savePayment(final @RequestBody PaymentDto paymentDto){
		return paymentService.savePayment(paymentDto);
	}

	/**
	 * Delete a payment by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deletePayment(@PathVariable Long id){
		return paymentService.deletePayment(id);
	}

}
