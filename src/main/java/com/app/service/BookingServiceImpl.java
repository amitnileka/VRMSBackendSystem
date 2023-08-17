package com.app.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookingRepository;
import com.app.dao.UserRepository;
import com.app.dto.ApiResponse;
import com.app.dto.BookingDto;
import com.app.dto.BookingResponseDto;
import com.app.dto.ProfileDto;
import com.app.entities.BookingDetailsEntity;
import com.app.entities.UserEntity;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BookingRepository bookingDao;
	
	@Autowired
	private UserRepository userDao;
	
	
	@Override
	public ApiResponse addBookingDetails(BookingDto bookingDto, Long userId) {
		// TODO Auto-generated method stub
		
		
		UserEntity users= userDao.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
		BookingDetailsEntity booking= mapper.map(bookingDto, BookingDetailsEntity.class);
		
		booking.setUsers(users);
		BookingDetailsEntity bookingEntity= bookingDao.save(booking);
		
		
		
		return new ApiResponse("Booking details added");
	}
	
	
  @Override
	public List<BookingDto> getMyBookings(Long userId) {
		// TODO Auto-generated method stub
	  UserEntity users= userDao.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
		List<BookingDetailsEntity> bookingEntity=users.getBookings();
		
		
		List<BookingDto> bookingDto=bookingEntity.stream().map(booking-> mapper.map(booking, BookingDto.class)).collect(Collectors.toList());
		
		return bookingDto;
		
	}
	  
	  @Override
	public List<BookingResponseDto> getAllBookings() {
		// TODO Auto-generated method stub
		  
		List<BookingDetailsEntity> bookingEntities=bookingDao.findAll();
		List<BookingResponseDto> bookingDto=bookingEntities.stream().map(booking-> mapper.map(booking, BookingResponseDto.class)).collect(Collectors.toList());
		
		for(int i=0;i<bookingEntities.size();i++) {
			bookingDto.get(i).setUser(mapper.map(bookingEntities.get(i).getUsers(), ProfileDto.class));
		}
		
		return bookingDto;
	}
	  
//	  @Override
//	public ApiResponse cancelBooking(Long bookingId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
