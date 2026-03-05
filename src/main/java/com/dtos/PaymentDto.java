package com.dtos;

import com.entities.Reservation;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	@NotNull
	private Long id;
	@NotNull
	private String currency;
	@NotNull
	private Long amount;
	@NotNull
	private String status;
	//private List<Reservation> reservations;
	@NotNull
	private String createdAt;
}
