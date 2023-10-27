package com.vux.example.RegisterLogin.Converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;

@Component
public class HubDetailConvert {
	@Autowired
	private DeviceConvert deviceConvert;

	public HubDetailResponse toResponse(HubDetailEntity entity) {
		HubDetailResponse response = new HubDetailResponse();
		response.setDevice(deviceConvert.toResponse(entity.getDevice()));
		response.setMaintenanceHistories(entity.getMaintenanceHistories());
		response.setTrademark(entity.getTrademark());
		response.setRatedPower(entity.getRatedPower());
		response.setLoadDuringPowerOutage(entity.getLoadDuringPowerOutage());
		response.setBatteryQuantity(entity.getBatteryCapacity());
		response.setBatteryNumber(entity.getBatteryNumber());
		response.setBatteryCapacity(entity.getBatteryCapacity());
		response.setProductionTime(entity.getProductionTime());
		response.setConductorType(entity.getConductorType());
		response.setCbPower(entity.getCbPower()) ;
		response.setSchneider(entity.getSchneider());
		response.setYearInstall(entity.getYearInstall());
		response.setNumber(entity.getNumber());
		response.setCurrentStatus(entity.getCurrentStatus());
		response.setLatestMaintenanceTime(entity.getLatestMaintenanceTime());
		response.setMaintenanceStatus(entity.getMaintenanceStatus());
		return response;
	}
}
