package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "booking_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookingDetailsEntity extends BaseEntity {

	private LocalDate bookDate;
	private LocalDate startDate;
	private LocalDate lastDate;
	
	private double amount;
	private double extraCharge;
	
	private double totalAmount;
	
	@Column(length = 20)
	private String status;
	
}
