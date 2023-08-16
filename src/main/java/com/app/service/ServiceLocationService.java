package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceLocationDto;
import com.app.entities.ServiceLocationEntity;

public interface ServiceLocationService {
	public ApiResponse addServiceLocation(ServiceLocationDto location);
	
	public ApiResponse deleteServiceLocation(Long id);
}
