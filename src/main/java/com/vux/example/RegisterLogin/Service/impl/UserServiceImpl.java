package com.vux.example.RegisterLogin.Service.impl;

import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.UserEntity;

public interface UserServiceImpl {

	Optional<UserEntity> findUserByUsername(String username);
	
	UserEntity save(UserEntity user);
	
	
}
