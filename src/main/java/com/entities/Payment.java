package com.entities;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private String status;
    private Long amount;

    //@OneToMany
    //private List<Reservation> reservations;
    private String createdAt;
}
