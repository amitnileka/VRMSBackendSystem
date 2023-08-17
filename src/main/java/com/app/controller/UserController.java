package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ChangePasswordDto;
import com.app.dto.RegisterUserDto;
import com.app.dto.SigninRequestDto;
import com.app.dto.SigninResponseDto;
import com.app.dto.ProfileDto;
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
	
	@GetMapping("/get_all_users")
	public List<ProfileDto> getAllUsers(){
		return userService.getUsers();
	}
	
	@PutMapping("/update_profile")
	public ApiResponse updateUserProfile(@RequestBody @Valid ProfileDto profileDto){
		return userService.editUserProfile(profileDto);
	}
	
	@GetMapping("/{id}")
	public ProfileDto getValidUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/change_password")
	public ApiResponse changePasswordOfUser(@RequestBody @Valid ChangePasswordDto passwordDto) {
		return userService.changePassword(passwordDto);
	}

}
