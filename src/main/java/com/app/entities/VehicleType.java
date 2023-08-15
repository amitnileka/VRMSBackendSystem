package com.app.entities;  


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="vehicle_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleType extends BaseEntity {
   
	@Column(length= 20)
	private VehicleTypeEnum vehicleType;
	
	@OneToMany(mappedBy = "vehicleBrand", cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<VehicleBrand> vehicleTypeList = new HashSet<>();       
	
	
}