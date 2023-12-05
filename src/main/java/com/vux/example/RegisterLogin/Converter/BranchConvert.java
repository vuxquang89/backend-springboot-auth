package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Payload.Request.BranchRequest;
import com.vux.example.RegisterLogin.Payload.Response.BranchResponse;
import com.vux.example.RegisterLogin.Payload.Response.SelectResponse;

@Component
public class BranchConvert {

	public BranchResponse toResponse(BranchEntity entity) {
		BranchResponse response = new BranchResponse();
		response.setBranchId(entity.getBranchId());
		response.setBranchName(entity.getBranchName());
		if(entity.getStaffLeader() != null) {
			response.setDeputyTechnicalDirector(entity.getStaffLeader().getDeputyTechnicalDirector());
			response.setPhoneDeputyTechnicalDirector(entity.getStaffLeader().getPhoneDeputyTechnicalDirector());
			response.setEmailDeputyTechnicalDirector(entity.getStaffLeader().getEmailDeputyTechnicalDirector());	
		}
		
		response.setBranchAddress(entity.getBranchAddress());
		return response;
	}
	
	public BranchEntity toEntity(BranchRequest response) {
		BranchEntity entity = new BranchEntity();
		entity.setBranchId(response.getBranchId());
		entity.setBranchName(response.getBranchName());
//		entity.getStaffLeader().setDeputyTechnicalDirector(response.getDeputyTechnicalDirector());
//		entity.getStaffLeader().setPhoneDeputyTechnicalDirector(response.getPhoneDeputyTechnicalDirector());
//		entity.getStaffLeader().setEmailDeputyTechnicalDirector(response.getEmailDeputyTechnicalDirector());
		entity.setBranchAddress(response.getBranchAddress());
		return entity;
	}
	
	public SelectResponse toBranchSelect(BranchEntity entity) {
		SelectResponse branchSelectResponse = new SelectResponse();
		branchSelectResponse.setValue(entity.getBranchId());
		branchSelectResponse.setLabel(entity.getBranchName());
		return branchSelectResponse;
	}
}
