package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

@Component
public class StaffLeaderConvert {

	public UserResponse toUserResponse(StaffLeaderEntity entity) {
		UserResponse response = new UserResponse();		
		response.setId(entity.getId());
		response.setFullname(entity.getDeputyTechnicalDirector());
		response.setEmail(entity.getEmailDeputyTechnicalDirector());
		response.setUsername(entity.getUsername());
		response.setStatus(entity.getStatus());
		if(entity.getStatus() == 0) {
			response.setStatusName("Inactivate");
		}else { response.setStatusName("Activate");}
		
		response.setPhone(entity.getPhoneDeputyTechnicalDirector());
		response.addRolesId(entity.getRoleId());
		response.addRolesName(entity.getRoleName());		
		response.setBranchId(entity.getBranch().getBranchId());
		response.setBranchName(entity.getBranch().getBranchName());
		return response;
	}
}
