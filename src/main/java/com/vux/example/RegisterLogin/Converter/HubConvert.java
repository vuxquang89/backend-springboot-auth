package com.vux.example.RegisterLogin.Converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Payload.Request.HubRequest;

import com.vux.example.RegisterLogin.Payload.Response.HubResponse;

@Component
public class HubConvert {
	
	@Autowired
	private UserConvert userConvert;
	@Autowired
	private BranchConvert branchConvert;
	@Autowired
	private HubDetailConvert hubDetailConvert;

	public HubResponse toResponse(HubEntity entity) {
		HubResponse response = new HubResponse();
		response.setHubId(entity.getHubId());
		response.setHubName(entity.getHubName());
		response.setHubManagerName(entity.getHubManagerName());
		response.setHubManagerPhone(entity.getHubManagerPhone());
		response.setHubCity(entity.getHubCity());
		response.setHubAddress(entity.getHubAddress());
		response.setUserResponse(userConvert.toResponse(entity.getPersonnelChargeName()));
		response.setBranchResponse(branchConvert.toResponse(entity.getBranchEntity()));
		if(entity.getHubDetails() != null && entity.getHubDetails().size() > 0) {
			for(HubDetailEntity hubDetailEntity : entity.getHubDetails()) {
				response.addHubDetailResponse(hubDetailConvert.toResponse(hubDetailEntity));
			}
			
		}
		
		return response;
	}
	
	public HubEntity toEntity(HubRequest request) {
		HubEntity entity = new HubEntity();
		entity.setHubName(request.getHubName());
		entity.setHubAddress(request.getHubAddress());
		entity.setHubCity(request.getHubCity());
		entity.setHubManagerName(request.getHubManagerName());
		entity.setHubManagerPhone(request.getHubManagerPhone());
		return entity;
	}
	
	public HubEntity toUpdateEntity(HubEntity entity, HubRequest request) {
		
		entity.setHubName(request.getHubName());
		entity.setHubAddress(request.getHubAddress());
		entity.setHubCity(request.getHubCity());
		entity.setHubManagerName(request.getHubManagerName());
		entity.setHubManagerPhone(request.getHubManagerPhone());
		return entity;
	}
}
