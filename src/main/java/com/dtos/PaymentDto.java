package com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDto {
	
	@NotNull
	private Long id;
	
	@NotBlank(message = "Le titre est obligatoire")
	private String titre;
	
	@NotBlank(message = "La transaction est obligatoire")
	private String transaction;
	
}
