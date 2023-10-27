package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

public interface UserServiceImpl {

	Optional<UserEntity> findUserById(Long id);
	Optional<UserEntity> findUserByUsername(String username);
	Optional<UserEntity> findUserByEmail(String email);
	
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Boolean existsByPhone(String phone);
	
	UserEntity save(UserEntity user);
	List<UserResponse> getAll();
	List<UserResponse> getUserRole(int roleId);
	List<UserEntity> getUserEntityRole(int roleId);
	boolean delete(long id);
	
}
