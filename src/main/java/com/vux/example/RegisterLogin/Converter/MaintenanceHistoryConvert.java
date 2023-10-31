package com.vux.example.RegisterLogin.Converter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Request.MaintenanceHistoryRequest;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;
import com.vux.example.RegisterLogin.Util.LocalDateConvert;

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
		String date = LocalDateConvert.stringToDateString(request.getMaintenanceTime());
		entity.setMaintenanceTime(LocalDate.parse(date));
		entity.setMaintenanceNote(request.getMaintenanceNote());
		return entity;
	}
}
