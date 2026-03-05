package com.services.impl;

import com.dtos.PaymentDto;
import com.dtos.ReservationDto;
import com.entities.Reservation;
import com.mappers.PaymentMapper;
import com.repositories.PaymentRepository;
import com.services.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Transactional
class ReservationServiceImpl {
    private final RestTemplate restTemplate;

    ReservationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //@Override
    @Transactional(readOnly = true)
    List<ReservationDto> getReservationsById(Long paymentId){
        //Contact by REST to get Reservations
        String url = "http://localhost:11082/reservations/";

        //Verification /reservations/{id}
        ResponseEntity<Reservation> data = restTemplate.getForEntity(url, Reservation.class);

        data.getBody();

        System.out.println(data.getBody());

        return null;
    }
}
