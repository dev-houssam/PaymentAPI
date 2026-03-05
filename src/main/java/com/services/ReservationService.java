package com.services;

import com.dtos.ReservationDto;

import java.util.List;


public interface ReservationService {
    /**
     * Récupère tous les reservations d'un payment particulier
     * @return la liste des reservations d'un payement
     */
    List<ReservationDto> getReservationsById(Long paymentId);
}
