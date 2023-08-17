package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookingDetailsEntity;

public interface BookingRepository extends JpaRepository<BookingDetailsEntity, Long> {

}
