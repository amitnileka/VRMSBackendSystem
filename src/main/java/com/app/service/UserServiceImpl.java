package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.ApiResponse;
import com.app.dto.ChangePasswordDto;
import com.app.dto.RegisterUserDto;
import com.app.dto.SigninRequestDto;
import com.app.dto.SigninResponseDto;
import com.app.dto.ProfileDto;
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
		
		return user != null ? new SigninResponseDto(user.getId(),"jwt","Sign In Successfull") : 
			new SigninResponseDto(null,"Nojwt","Sign In Unsuccessfull");
	}
	
	@Override
	public List<ProfileDto> getUsers() {
		List<UserEntity> userList = userRepo.findAll();
		
		List<ProfileDto> usersDto = userList.stream().
				map(userEntity -> mapper.map(userEntity,ProfileDto.class))
				.collect(Collectors.toList());

		return usersDto;
	}
	
	@Override
	public ProfileDto getUserById(Long id) {
		return mapper.map(userRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid User Id")), 
				          ProfileDto.class);
		
	}
	
	
	@Override
	public ApiResponse editUserProfile(ProfileDto profile) {
		UserEntity oldUserDetails = userRepo.findById(profile.getId())
				.orElseThrow(() -> new RuntimeException("Invalid User Details"));
		UserEntity newUser = new UserEntity(profile.getFirstName(),profile.getLastName(),
				                             oldUserDetails.getEmail(),oldUserDetails.getPassword(),profile.getAge(),
				                             profile.getMobileNo(),profile.getAadharNo(),profile.getLicenseNo(),
				                             oldUserDetails.getBookings());
		newUser.setId(profile.getId());
		userRepo.save(newUser);
		return new ApiResponse("Profile Updated Successfully!!!");
	}
	
	
	@Override
	public ApiResponse changePassword(ChangePasswordDto passDto) {
		UserEntity user = userRepo.findById(passDto.getId())
				.orElseThrow(() -> new RuntimeException("Invalid User Id"));
		
		if(user.getPassword().equals(passDto.getOldPassword())) {
			user.setPassword(passDto.getNewPassword());
			return new ApiResponse("Password Changed Successfully");
		}
		return new ApiResponse("Your Old Password is not Matched");
		
	}
	
}
