package com.services.external;

import org.springframework.stereotype.Component;


import com.services.external.ReservationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationClient {

    private final RestTemplate restTemplate;

    private final String RESERVATION_API_URL = "http://localhost:11082/reservations";

    public ReservationClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createReservation(ReservationRequest request) {

        restTemplate.postForObject(
                RESERVATION_API_URL,
                request,
                Void.class
        );
    }
}
