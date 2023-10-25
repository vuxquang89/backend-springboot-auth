package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.UserConvert;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.Repo.UserRepository;
import com.vux.example.RegisterLogin.Service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConvert userConvert;
	
	@Override
	public Optional<UserEntity> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public Optional<UserEntity> findUserById(Long id) {
		return userRepository.findById(id);
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
	public Boolean existsByPhone(String phone) {
		return userRepository.existsByPhone(phone);
	}
	
	@Override
	public Optional<UserEntity> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}
	@Override
	public boolean delete(long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<UserResponse> getAll() {
		List<UserEntity> entities = userRepository.findAll();
		List<UserResponse> responses = new ArrayList<UserResponse>();
		for(UserEntity entity : entities) {
			if(!entity.getUsername().equalsIgnoreCase("admin")) {
				responses.add(userConvert.toResponse(entity));
			}
		}
		return responses;
	}
}
