package com.services.external;

import org.springframework.stereotype.Component;



public class ReservationRequest {

    private Long userId;
    private Long showId;
    private Integer seats;
    private Long paymentId;

    public ReservationRequest() {}

    public ReservationRequest(Long userId, Long showId, Integer seats, Long paymentId) {
        this.userId = userId;
        this.showId = showId;
        this.seats = seats;
        this.paymentId = paymentId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getShowId() {
        return showId;
    }

    public Integer getSeats() {
        return seats;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}