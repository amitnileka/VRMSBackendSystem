package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookingDto {

	@NotBlank(message = "should enter start date")
	private LocalDate startDate;
	
	@NotBlank(message = "should enter end date")
	private LocalDate endDate;
	 
	private Double amount;
	
	private Double extraCharge;
	
	private Double totalAmount;
	 
	private Long vehicleId;
}
