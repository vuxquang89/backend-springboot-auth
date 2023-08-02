package com.vux.example.RegisterLogin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Repo.UserRepository;
import com.vux.example.RegisterLogin.Service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<UserEntity> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	@Override
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	
	@Override
	public Optional<UserEntity> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}
}
