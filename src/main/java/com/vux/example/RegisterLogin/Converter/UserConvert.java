package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;

@Component
public class UserConvert {

	public UserEntity accountToEntity(Payload payload) {
		UserEntity entity = new UserEntity();
		entity.setId(102L);
		entity.setUsername((String)payload.get("email"));
		entity.setEmail((String)payload.get("email"));
		entity.addRole(new RoleEntity("ROLE_USER"));
		return entity;
	}
	
}
