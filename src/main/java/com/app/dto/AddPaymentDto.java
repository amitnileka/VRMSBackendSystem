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
  
	private String cardNo;
	private String cardHolderName;
	private String cvv;
	private String expiryDate;
	private Double paymentAmount;
	private Long bookingId;
}
