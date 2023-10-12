package com.vux.example.RegisterLogin.Converter;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;

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
	
}
