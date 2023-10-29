package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceResponse;

@Component
public class MaintenanceConvert {

	public MaintenanceResponse toMaintenanceResponse(MaintenanceHistoryEntity entity) {
		MaintenanceResponse response = new MaintenanceResponse();
		response.setMaintenanseId(entity.getId());
		response.setMaintenanceTime(entity.getMaintenanceTime().toString());
		response.setMaintenanceNote(entity.getMaintenanceNote());
		return response;
	}
}
