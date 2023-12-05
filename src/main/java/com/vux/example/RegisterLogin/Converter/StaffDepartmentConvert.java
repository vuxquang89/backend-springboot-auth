package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffDepartmentEntity;
import com.vux.example.RegisterLogin.Payload.Response.StaffDepartmentResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

@Component
public class StaffDepartmentConvert {

	public StaffDepartmentResponse toResponse(StaffDepartmentEntity entity) {
		StaffDepartmentResponse response = new StaffDepartmentResponse();
		response.setId(entity.getId());
		response.setFullname(entity.getFullname());
		response.setPhone(entity.getPhone());
		response.setEmail(entity.getEmail());
		response.setStatus(entity.getStatus());
		if(entity.getStatus() == 0) {
			response.setStatusName("Inactivate");
		}else { response.setStatusName("Activate");}
		response.setUsername(entity.getUsername());
		response.setRoleName(entity.getRoleName());
		response.setRoleId(entity.getRoleId());
		return response;
	}
	
	public UserResponse toUserResponse(StaffDepartmentEntity entity) {
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
		response.addRolesId(entity.getRoleId());
		response.addRolesName(entity.getRoleName());		
		
		return response;
	}
}
