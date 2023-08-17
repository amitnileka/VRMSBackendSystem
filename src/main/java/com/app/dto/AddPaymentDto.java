package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddPaymentDto {
  
	private String paymentStatus;
	private double paymentAmount;
	private LocalDate timestamp;
	private Long bookingId;
}
