package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.CredentialsRequestDto;
import com.app.dto.CredentialsResponseDto;

public interface AdminService {
	
	public CredentialsResponseDto getValidAdmin(CredentialsRequestDto loginAdminDto);
	public ApiResponse getValidAdminByEmail(String email);
	public ApiResponse updateForgotPasswordOfAdmin(CredentialsRequestDto userDto);
}
