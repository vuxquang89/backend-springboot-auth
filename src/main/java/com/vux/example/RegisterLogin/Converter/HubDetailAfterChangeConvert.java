package com.vux.example.RegisterLogin.Converter;


import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailAfterChange;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAfterChangeResponse;

@Component
public class HubDetailAfterChangeConvert {

	public HubDetailAfterChangeResponse toResponse(HubDetailAfterChange entity) {
		HubDetailAfterChangeResponse response = new HubDetailAfterChangeResponse();
		
		response.setHubDetailId(entity.getId());		
		response.setDeviceId(entity.getDeviceId());
		//response.setDeviceName(entity.getDevice().getDeviceName());
		
		response.setHubId(entity.getHubId());
		response.setModifiedBy(entity.getUserModifiedBy());
		response.setModifiedDate(entity.getUserModifiedDate());
		response.setHistoryChangeId(entity.getHistoryChangeId());
		response.setStatus(entity.getStatus());
				
		response.setTrademark(entity.getTrademark());
		response.setRatedPower(entity.getRatedPower());
		response.setLoadDuringPowerOutage(entity.getLoadDuringPowerOutage());
		response.setBatteryQuantity(entity.getBatteryQuantity());
		response.setBatteryNumber(entity.getBatteryNumber());
		response.setBatteryCapacity(entity.getBatteryCapacity());
		response.setProductionTime(entity.getProductionTime());
		response.setConductorType(entity.getConductorType());
		response.setCbPower(entity.getCbPower()) ;
		response.setSchneider(entity.getSchneider());
		response.setYearInstall(entity.getYearInstall());
		response.setNumber(entity.getNumber());
		response.setDateMaintenance(entity.getDateMaintenance());
		response.setCurrentStatus(entity.getCurrentStatus());
		response.setLatestMaintenanceTime( entity.getLatestMaintenanceTime());		
		
		response.setOrderMaintenance(entity.getOrderMaintenance());
		response.setStatusDelete(entity.getStatusDelete());
		
		return response;
	}
}
