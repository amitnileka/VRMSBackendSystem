package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.SigninRequestDto;
import com.app.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByEmailAndPassword(String email, String password);
}
