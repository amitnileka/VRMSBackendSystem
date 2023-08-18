package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddFeedbackToBookingDto {

	private Long bookingId;
	
	private String bookingFeedback;

	private Integer rating;
	
	
}
