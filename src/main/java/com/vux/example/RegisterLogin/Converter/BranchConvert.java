package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Payload.Request.BranchRequest;
import com.vux.example.RegisterLogin.Payload.Response.BranchResponse;

@Component
public class BranchConvert {

	public BranchResponse toResponse(BranchEntity entity) {
		BranchResponse response = new BranchResponse();
		response.setBranchId(entity.getBranchId());
		response.setBranchName(entity.getBranchName());
		response.setDeputyTechnicalDirector(entity.getDeputyTechnicalDirector());
		response.setPhoneDeputyTechnicalDirector(entity.getPhoneDeputyTechnicalDirector());
		response.setEmailDeputyTechnicalDirector(entity.getEmailDeputyTechnicalDirector());
		response.setBranchAddress(entity.getBranchAddress());
		return response;
	}
	
	public BranchEntity toEntity(BranchRequest response) {
		BranchEntity entity = new BranchEntity();
		entity.setBranchId(response.getBranchId());
		entity.setBranchName(response.getBranchName());
		entity.setDeputyTechnicalDirector(response.getDeputyTechnicalDirector());
		entity.setPhoneDeputyTechnicalDirector(response.getPhoneDeputyTechnicalDirector());
		entity.setEmailDeputyTechnicalDirector(response.getEmailDeputyTechnicalDirector());
		entity.setBranchAddress(response.getBranchAddress());
		return entity;
	}
}
