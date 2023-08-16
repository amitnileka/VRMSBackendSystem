package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ServiceLocationRepository;
import com.app.dao.VehicleBrandRepository;
import com.app.dao.VehicleRepository;
import com.app.dao.VehicleTypeRepository;
import com.app.dto.AddVehicalDto;
import com.app.dto.ApiResponse;
import com.app.entities.ServiceLocationEntity;
import com.app.entities.Vehicle;
import com.app.entities.VehicleBrand;
import com.app.entities.VehicleType;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private ServiceLocationRepository serviceLocationRepo;
	
	@Autowired
	private VehicleBrandRepository vehicleBrandRepo;
	
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepo;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addVehicle(AddVehicalDto vehicleDto) {

		
		ServiceLocationEntity location = serviceLocationRepo.findById(vehicleDto.getServiceLocationId()).orElseThrow(()->new RuntimeException("location not found"));
		VehicleBrand vehicleBrand = vehicleBrandRepo.findById(vehicleDto.getBrandId()).orElseThrow(()->new RuntimeException("Brand not found"));
		VehicleType vehicleType = vehicleTypeRepo.findById(vehicleDto.getTypeId()).orElseThrow(()->new RuntimeException("Type not found"));
		
		
		Vehicle vehicle = mapper.map(vehicleDto, Vehicle.class);
		vehicle.setBrand(vehicleBrand);
		vehicle.setType(vehicleType);
		
		location.addVehicle(vehicle);
		
		
		
		return new ApiResponse("Vehicle added");
	}
	
	
	@Override
	public ApiResponse deleteVehicle(Long id) {
		return null;
	}
	
}
