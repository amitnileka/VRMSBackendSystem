package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ServiceLocationRepository;
import com.app.dto.ApiResponse;
import com.app.dto.ServiceLocationDto;
import com.app.dto.ServiceLocationResponseDto;
import com.app.entities.ServiceLocationEntity;

@Service
@Transactional
public class ServiceLocationServiceImpl implements ServiceLocationService {

	@Autowired
	private ServiceLocationRepository locationRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addServiceLocation(ServiceLocationDto locationDto) {
		
		ServiceLocationEntity location = mapper.map(locationDto, ServiceLocationEntity.class );
		
		ServiceLocationEntity locationEntity = locationRepository.save(location);
		 
		return new ApiResponse("location added");
	}
	
	
	@Override
	public ApiResponse deleteServiceLocation(Long id) {
	
		ServiceLocationEntity location = locationRepository.findById(id).orElseThrow(()-> new RuntimeException("location not found"));

		locationRepository.delete(location);
		
		return new ApiResponse("location deleted");
	}
	
	
	@Override
	public List<ServiceLocationResponseDto> getAllLocations() {
	
		List<ServiceLocationEntity> serviceLocations = locationRepository.findAll();
		
		List<ServiceLocationResponseDto> serviceLocationDtos = serviceLocations.stream() //Stream<Emp>
				.map(service -> mapper.map(service, ServiceLocationResponseDto.class)) //Stream<DTO>
				.collect(Collectors.toList());
		
		
		return serviceLocationDtos;
	}
	
}
