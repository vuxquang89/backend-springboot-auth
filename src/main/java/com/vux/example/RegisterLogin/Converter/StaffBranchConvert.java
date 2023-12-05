package com.vux.example.RegisterLogin.Converter;


import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;
import com.vux.example.RegisterLogin.Payload.Response.StaffBranchResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

@Component
public class StaffBranchConvert {

	public UserResponse toUserResponse(StaffBranchEntity entity) {
		UserResponse response = new UserResponse();		
		response.setId(entity.getId());
		response.setFullname(entity.getHubManagerName());
		response.setEmail(entity.getEmail());
		response.setUsername(entity.getUsername());
		response.setStatus(entity.getStatus());
		if(entity.getStatus() == 0) {
			response.setStatusName("Inactivate");
		}else { response.setStatusName("Activate");}
		
		response.setPhone(entity.getHubManagerPhone());
		response.addRolesId(entity.getRoleId());
		response.addRolesName(entity.getRoleName());		
		response.setBranchId(entity.getBranchStaffEntity().getBranchId());
		response.setBranchName(entity.getBranchStaffEntity().getBranchName());
		return response;
	}
	
	public StaffBranchResponse toStaffBranchResponse(StaffBranchEntity entity) {
		StaffBranchResponse response = new StaffBranchResponse();
		response.setId(entity.getId());
		response.setHubManagerName(entity.getHubManagerName());
		response.setHubManagerPhone(entity.getHubManagerPhone());
		response.setEmail(entity.getEmail());
		response.setStatus(entity.getStatus());
		
		response.setUsername(entity.getUsername());
		response.setRoleName(entity.getRoleName());	
		response.setRoleId(entity.getRoleId());
		
		return response;
	}
}
