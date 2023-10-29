package com.vux.example.RegisterLogin.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Request.MaintenanceHistoryRequest;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;

@Component
public class MaintenanceHistoryConvert {
	
	@Autowired
	private HubDetailConvert hubDetailConvert;

	public MaintenanceHistoryResponse toResponse(MaintenanceHistoryEntity entity) {
		MaintenanceHistoryResponse response = new MaintenanceHistoryResponse();
		response.setId(entity.getId());
		response.setHubDetailResponse(hubDetailConvert.toResponse(entity.getHubDetail()));
		response.setMaintenanceTime(entity.getMaintenanceTime().toString());
		response.setMaintenanceNote(entity.getMaintenanceNote());
		return response;
	}
	
	
	public MaintenanceHistoryEntity toEntity(MaintenanceHistoryRequest request) {
		MaintenanceHistoryEntity entity = new MaintenanceHistoryEntity();
		entity.setMaintenanceTime(request.getMaintenanceTime());
		entity.setMaintenanceNote(request.getMaintenanceNote());
		return entity;
	}
}
