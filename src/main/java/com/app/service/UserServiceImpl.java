package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.ApiResponse;
import com.app.dto.RegisterUserDto;
import com.app.dto.SigninRequestDto;
import com.app.dto.SigninResponseDto;
import com.app.entities.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public ApiResponse addUser(RegisterUserDto userDto) {
		
		UserEntity userEntity = mapper.map(userDto,UserEntity.class);
		
		UserEntity user = userRepo.save(userEntity);
		
		return new ApiResponse("Registration Successfull");
	}
	
	@Override
	public SigninResponseDto getValidUser(SigninRequestDto loginUserDto) {
		String email = loginUserDto.getEmail();
		String password = loginUserDto.getPassword();
		UserEntity user = userRepo.findByEmailAndPassword(email, password);
		
		return user != null ? new SigninResponseDto("jwt","Sign In Successfull") : new SigninResponseDto("Nojwt","Sign In Unsuccessfull");
	
			
	}
	
}
