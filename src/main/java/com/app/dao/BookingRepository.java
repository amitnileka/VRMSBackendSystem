package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookingDetailsEntity;
import com.app.entities.Vehicle;

public interface BookingRepository extends JpaRepository<BookingDetailsEntity, Long> {
	
	Optional<List<BookingDetailsEntity>> findByVehicle(Vehicle v);

}
