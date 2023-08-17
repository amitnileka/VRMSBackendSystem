package com.app.service;

import java.util.List;

import com.app.dto.AddVehicalDto;
import com.app.dto.ApiResponse;
import com.app.dto.ServiceLocationDto;
import com.app.dto.UpdateVehicleDto;
import com.app.dto.VehicleResponseDto;
import com.app.entities.Vehicle;

public interface VehicleService {
	public ApiResponse addVehicle(AddVehicalDto vehicle);
	
	public ApiResponse deleteVehicle(Long id);
	
	public List<VehicleResponseDto> getAllVehicles(); 
	
	public ApiResponse updateVehicle(UpdateVehicleDto vehicleDto);
}
