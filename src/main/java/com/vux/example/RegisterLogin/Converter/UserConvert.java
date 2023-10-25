package com.vux.example.RegisterLogin.Converter;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Payload.Request.UserRequest;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.lib.Password;

@Component
public class UserConvert {

	public UserEntity accountToEntity(Payload payload) {
		UserEntity entity = new UserEntity();
		entity.setId(Long.parseLong(RandomStringUtils.randomNumeric(8)));
		entity.setUsername((String)payload.get("email"));
		entity.setEmail((String)payload.get("email"));
		entity.addRole(new RoleEntity("ROLE_USER"));
		return entity;
	}
	
	public UserResponse toResponse(UserEntity entity) {
		UserResponse response = new UserResponse();
		response.setId(entity.getId());
		response.setFullname(entity.getFullname());
		response.setEmail(entity.getEmail());
		response.setUsername(entity.getUsername());
		response.setStatus(entity.getStatus());
		response.setPhone(entity.getPhone());
		List<RoleEntity> roles = entity.getRoles();
		for(RoleEntity role : roles) {
			response.addRole(role.getId());
		}
//		response.setRoles(entity.getRoles());
		return response;
	}
	
	public UserEntity toEntity(UserRequest request) {
		UserEntity entity = new UserEntity();
		entity.setUsername(request.getUsername());
		entity.setPassword(Password.encoderPassword(request.getPassword()));
		entity.setEmail(request.getEmail());
		entity.setFullname(request.getFullname());
		entity.setPhone(request.getPhone());
		return entity;
	}
	
	public UserEntity toUpdateEntity(UserEntity entity, UserRequest request) {
		entity.setFullname(request.getFullname());
		entity.setPhone(request.getPhone());
		entity.setEmail(entity.getEmail());
		if(request.getRole() != 1) {
			entity.getRoles().set(0, new RoleEntity(request.getRole()));
		}else {
			entity.getRoles().set(0,new RoleEntity(3));
		}
				
		return entity;
	}
	
}
