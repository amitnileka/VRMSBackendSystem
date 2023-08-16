package com.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RegisterUserDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int age;
	private String mobileNo;
	private String aadharNo;
	private String licenseNo;

}
