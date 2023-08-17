package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.BookingDto;
import com.app.dto.BookingResponseDto;

public interface BookingService {

	public ApiResponse addBookingDetails(BookingDto bookingDto, Long userId);
	public List<BookingDto> getMyBookings(Long userId);
	public List<BookingResponseDto> getAllBookings();
	//public ApiResponse cancelBooking(Long bookingId);
}
