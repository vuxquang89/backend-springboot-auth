package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;
import com.vux.example.RegisterLogin.Payload.Request.DeviceRequest;
import com.vux.example.RegisterLogin.Payload.Response.DeviceResponse;

@Component
public class DeviceConvert {

	public DeviceResponse toResponse(DeviceEntity entity) {
		DeviceResponse response = new DeviceResponse();
		response.setId(entity.getId());
		response.setDeviceName(entity.getDeviceName());
		return response;
	}
	
	public DeviceEntity toEntity(DeviceRequest request) {
		DeviceEntity entity = new DeviceEntity();
		entity.setDeviceName(request.getDeviceName());
		return entity;
	}
}
