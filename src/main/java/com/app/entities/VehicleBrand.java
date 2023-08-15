package com.app.entities; 

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vehicle_brand")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class VehicleBrand extends BaseEntity {
  
	@Column (length = 20)
	private String vehicleBrand;
	
	@Enumerated(EnumType.STRING)
	private PricingPkg pricingPkg;
	
	private long pricingPerKm;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Vehicle> vehicleList = new HashSet<>();
	
	 
}