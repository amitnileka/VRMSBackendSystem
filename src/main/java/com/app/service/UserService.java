package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ChangePasswordDto;
import com.app.dto.ProfileDto;
import com.app.dto.RegisterUserDto;
import com.app.dto.SigninRequestDto;
import com.app.dto.SigninResponseDto;



public interface UserService {
	public ApiResponse addUser(RegisterUserDto registerUserDto);
	public SigninResponseDto getValidUser(SigninRequestDto loginUserDto);
	public List<ProfileDto> getUsers();
	public ApiResponse editUserProfile(ProfileDto profile);
	public ProfileDto getUserById(Long id);
	public ApiResponse changePassword(ChangePasswordDto passDto);
}
