package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.RegisterUserDto;
import com.app.dto.SigninRequestDto;
import com.app.dto.SigninResponseDto;

public interface UserService {
	public ApiResponse addUser(RegisterUserDto registerUserDto);
	public SigninResponseDto getValidUser(SigninRequestDto loginUserDto);

}
