package com.app.service;

import com.app.dto.AddVehicalDto;
import com.app.dto.ApiResponse;
import com.app.dto.ServiceLocationDto;

public interface VehicleService {
	public ApiResponse addVehicle(AddVehicalDto vehicle);
	
	public ApiResponse deleteVehicle(Long id);
}
