package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.RegisterUserDto;
import com.app.dto.SigninRequestDto;
import com.app.dto.SigninResponseDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ApiResponse registerUserDetails(@RequestBody @Valid RegisterUserDto userDto){
		return userService.addUser(userDto);
	}
	
	@PostMapping("/login")
	public SigninResponseDto signInUser(@RequestBody @Valid SigninRequestDto userDto){
		return userService.getValidUser(userDto);
	}
	
	

}
