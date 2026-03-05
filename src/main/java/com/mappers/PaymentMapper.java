package com.mappers;

import com.dtos.PaymentDto;
import com.entities.Payment;

public class PaymentMapper {

    public static PaymentDto toDto(Payment payment){

        if(payment == null){
            return null;
        }

        return PaymentDto.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .status(payment.getStatus())
                .createdAt(payment.getCreatedAt())
                .build();
    }

    public static Payment toEntity(PaymentDto dto){

        if(dto == null){
            return null;
        }

        return Payment.builder()
                .id(dto.getId())          // utile pour update
                .amount(dto.getAmount())
                .currency(dto.getCurrency())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}