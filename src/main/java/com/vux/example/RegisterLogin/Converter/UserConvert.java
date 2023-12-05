package com.vux.example.RegisterLogin.Converter;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffDepartmentEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;
import com.vux.example.RegisterLogin.Payload.Request.UserRequest;
import com.vux.example.RegisterLogin.Payload.Response.OptionSelectResponse;
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
		if(entity.getStatus() == 0) {
			response.setStatusName("Inactivate");
		}else { response.setStatusName("Activate");}
		
		response.setPhone(entity.getPhone());
		List<RoleEntity> roles = entity.getRoles();
		for(RoleEntity role : roles) {
			response.addRolesName(role.getName());
			response.addRolesId(role.getId());
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
		entity.setEmail(request.getEmail());
		entity.setStatus(request.getStatus());
		if(request.getRole() != 1) {
			entity.getRoles().set(0, new RoleEntity(request.getRole()));
		}else {
			entity.getRoles().set(0,new RoleEntity(5));
		}
				
		return entity;
	}
	
	public OptionSelectResponse toOptionSelect(UserEntity entity) {
		OptionSelectResponse response = new OptionSelectResponse();
//		response.setName("userId");
		response.setValue(entity.getId());
		response.setLabel(entity.getFullname());
		return response;
	}
	
	public OptionSelectResponse toManagerOptionSelect(StaffBranchEntity entity) {
		OptionSelectResponse response = new OptionSelectResponse();
//		response.setName("userId");
		response.setValue(entity.getId());
		response.setLabel(entity.getHubManagerName());
		return response;
	}
	
	public StaffDepartmentEntity toDepartmentEntity(UserEntity entity) {
		StaffDepartmentEntity departmentEntity = new StaffDepartmentEntity();
		departmentEntity.setId(entity.getId());
		departmentEntity.setFullname(entity.getFullname());
		departmentEntity.setPhone(entity.getPhone());
		departmentEntity.setEmail(entity.getEmail());
		departmentEntity.setStatus(entity.getStatus());
		
		departmentEntity.setUsername(entity.getUsername());
		departmentEntity.setRoleName(entity.getRoles().get(0).getName());	
		departmentEntity.setRoleId(entity.getRoles().get(0).getId());
		
		
		return departmentEntity;
	}
	
	public StaffBranchEntity toBranchEntity(UserEntity entity) {
		StaffBranchEntity branchEntity = new StaffBranchEntity();
		branchEntity.setId(entity.getId());
		branchEntity.setHubManagerName(entity.getFullname());
		branchEntity.setHubManagerPhone(entity.getPhone());
		branchEntity.setEmail(entity.getEmail());
		branchEntity.setStatus(entity.getStatus());
		
		branchEntity.setUsername(entity.getUsername());
		branchEntity.setRoleName(entity.getRoles().get(0).getName());	
		branchEntity.setRoleId(entity.getRoles().get(0).getId());
		
		return branchEntity;
	}
	
	public StaffLeaderEntity toLeaderEntity(UserEntity entity) {
		StaffLeaderEntity branchEntity = new StaffLeaderEntity();
		branchEntity.setId(entity.getId());
		branchEntity.setDeputyTechnicalDirector(entity.getFullname());
		branchEntity.setPhoneDeputyTechnicalDirector(entity.getPhone());
		branchEntity.setEmailDeputyTechnicalDirector(entity.getEmail());
		branchEntity.setStatus(entity.getStatus());
		
		branchEntity.setUsername(entity.getUsername());
		branchEntity.setRoleName(entity.getRoles().get(0).getName());	
		branchEntity.setRoleId(entity.getRoles().get(0).getId());
		
		return branchEntity;
	}
}
