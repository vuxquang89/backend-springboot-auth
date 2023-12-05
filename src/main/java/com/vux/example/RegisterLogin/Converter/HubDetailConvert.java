package com.vux.example.RegisterLogin.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailAfterChange;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Request.HubDetailRequest;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAlarmResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailListResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailUserResponse;

@Component
public class HubDetailConvert {
	
	@Autowired
	private MaintenanceConvert mainConvert;
	
	//private LocalDateConverter localDateConverter;
	
	public HubDetailEntity toUpdateEntity(HubDetailEntity entity, HubDetailRequest request) {
		entity.setTrademark(request.getTrademark());
		
		entity.setRatedPower(request.getRatedPower());
		
		entity.setLoadDuringPowerOutage(request.getLoadDuringPowerOutage());
		
		entity.setBatteryQuantity(request.getBatteryQuantity());
		
		entity.setBatteryNumber(request.getBatteryNumber());
		
		entity.setBatteryCapacity(request.getBatteryCapacity());
		
		entity.setProductionTime(request.getProductionTime());
		
		entity.setConductorType(request.getConductorType());
		
		entity.setCbPower(request.getCbPower());
		
		entity.setSchneider(request.getSchneider());
		
		entity.setYearInstall(request.getYearInstall());
		
		entity.setNumber(request.getNumber());
		
		if(request.getDateMaintenance() > 30) {
			entity.setDateMaintenance(request.getDateMaintenance());
		}
		
		entity.setOrderMaintenance(request.getOrderMaintenance());
		entity.setStatusDelete(request.getStatusDelete());
		
		entity.setCurrentStatus(request.getCurrentStatus());
		return entity;
	}
	
	public HubDetailAlarmResponse toAlarm(HubDetailEntity entity) {
		HubDetailAlarmResponse response = new HubDetailAlarmResponse();
		
		response.setHubDetailId(entity.getId());
		
		response.setDeviceId(entity.getDevice().getId());
		
		response.setDeviceName(entity.getDevice().getDeviceName());
		
		response.setHubId(entity.getHubEntity().getHubId());
		
		response.setHubName(entity.getHubEntity().getHubName());
			
		response.setBranchId(entity.getHubEntity().getBranchEntity().getBranchId());
		
		response.setBranchName(entity.getHubEntity().getBranchEntity().getBranchName());
		return response;
	}
	
	public HubDetailEntity toEntity(HubDetailRequest request) {
		HubDetailEntity entity = new HubDetailEntity();
		
		entity.setTrademark(request.getTrademark());
		
		entity.setRatedPower(request.getRatedPower());
		
		entity.setLoadDuringPowerOutage(request.getLoadDuringPowerOutage());
		
		entity.setBatteryQuantity(request.getBatteryQuantity());
		
		entity.setBatteryNumber(request.getBatteryNumber());
		
		entity.setBatteryCapacity(request.getBatteryCapacity());
		
		entity.setProductionTime(request.getProductionTime());
		
		entity.setConductorType(request.getConductorType());
		
		entity.setCbPower(request.getCbPower());
		
		entity.setSchneider(request.getSchneider());
		
		entity.setYearInstall(request.getYearInstall());
		
		entity.setNumber(request.getNumber());
		
		entity.setOrderMaintenance(request.getOrderMaintenance());
		entity.setStatusDelete(request.getStatusDelete());
		
		entity.setCurrentStatus(request.getCurrentStatus());
		
		entity.setDateMaintenance(request.getDateMaintenance());
		if(request.getOrderMaintenance() == false || request.getDateMaintenance() <= 30) {
			entity.setDateMaintenance(60);
		}
		
		return entity;
	}
	
	public HubDetailListResponse toListResponse(HubDetailEntity entity) {
		HubDetailListResponse response = new HubDetailListResponse();
		response.setHubId(entity.getHubEntity().getHubId());
		response.setHubName(entity.getHubEntity().getHubName());
		return response;
	}
	

	public HubDetailResponse toResponse(HubDetailEntity entity) {
		HubDetailResponse response = new HubDetailResponse();
		response.setHubDetailId(entity.getId());		
		response.setDeviceId(entity.getDevice().getId());
		response.setDeviceName(entity.getDevice().getDeviceName());
		response.setBackgroundColor(entity.getDevice().getBackgroundColor());
		response.setModifiedBy(entity.getModifiedBy());
		response.setModifiedDate(entity.getModifiedDate().toString());
		
		response.setHubId(entity.getHubEntity().getHubId());
		response.setHubName(entity.getHubEntity().getHubName());
		response.setHubAddress(entity.getHubEntity().getHubAddress());
		response.setHubCity(entity.getHubEntity().getHubCity());
		response.setHubManagerName(entity.getHubEntity().getStaffBranch().getHubManagerName());
		response.setHubManagerPhone(entity.getHubEntity().getStaffBranch().getHubManagerPhone());
		
		response.setUserId(entity.getHubEntity().getStaffDepartment().getId());
		response.setUsername(entity.getHubEntity().getStaffDepartment().getUsername());
		response.setEmail(entity.getHubEntity().getStaffDepartment().getEmail());
		response.setFullname(entity.getHubEntity().getStaffDepartment().getFullname());
		response.setPhone(entity.getHubEntity().getStaffDepartment().getPhone());
		
		response.setBranchId(entity.getHubEntity().getBranchEntity().getBranchId());
		response.setBranchName(entity.getHubEntity().getBranchEntity().getBranchName());
		response.setDeputyTechnicalDirector(entity.getHubEntity().getBranchEntity().getStaffLeader().getDeputyTechnicalDirector());
		response.setPhoneDeputyTechnicalDirector(entity.getHubEntity().getBranchEntity().getStaffLeader().getPhoneDeputyTechnicalDirector());
		response.setEmailDeputyTechnicalDirector(entity.getHubEntity().getBranchEntity().getStaffLeader().getEmailDeputyTechnicalDirector());
		response.setBranchAddress(entity.getHubEntity().getBranchEntity().getBranchAddress());
		
		if(entity.getMaintenanceHistories() != null) {
			for(MaintenanceHistoryEntity mEntity : entity.getMaintenanceHistories()) {
				response.addMaintenanceResponse(mainConvert.toMaintenanceResponse(mEntity));
			}
		}
		
		
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
		response.setLatestMaintenanceTime( entity.getLatestMaintenanceTime().toString());
		response.setAlarmMaintenanceStatus(entity.getAlarmMaintenance());
		
		response.setOrderMaintenance(entity.getOrderMaintenance());
		response.setStatusDelete(entity.getStatusDelete());
		
		return response;
	}
	
	public HubDetailUserResponse toUserResponse(HubDetailEntity entity) {
		HubDetailUserResponse response = new HubDetailUserResponse();
		response.setHubDetailId(entity.getId());		
		response.setDeviceId(entity.getDevice().getId());
		response.setDeviceName(entity.getDevice().getDeviceName());
		response.setBackgroundColor(entity.getDevice().getBackgroundColor());
		
		response.setHubId(entity.getHubEntity().getHubId());
		response.setHubName(entity.getHubEntity().getHubName());
		response.setHubAddress(entity.getHubEntity().getHubAddress());
		response.setHubCity(entity.getHubEntity().getHubCity());
		response.setHubManagerName(entity.getHubEntity().getStaffBranch().getHubManagerName());
		response.setHubManagerPhone(entity.getHubEntity().getStaffBranch().getHubManagerPhone());
		
		response.setUserId(entity.getHubEntity().getStaffDepartment().getId());
		response.setUsername(entity.getHubEntity().getStaffDepartment().getUsername());
		response.setEmail(entity.getHubEntity().getStaffDepartment().getEmail());
		response.setFullname(entity.getHubEntity().getStaffDepartment().getFullname());
		response.setPhone(entity.getHubEntity().getStaffDepartment().getPhone());
		
		response.setBranchId(entity.getHubEntity().getBranchEntity().getBranchId());
		response.setBranchName(entity.getHubEntity().getBranchEntity().getBranchName());
		response.setDeputyTechnicalDirector(entity.getHubEntity().getBranchEntity().getStaffLeader().getDeputyTechnicalDirector());
		response.setPhoneDeputyTechnicalDirector(entity.getHubEntity().getBranchEntity().getStaffLeader().getPhoneDeputyTechnicalDirector());
		response.setEmailDeputyTechnicalDirector(entity.getHubEntity().getBranchEntity().getStaffLeader().getEmailDeputyTechnicalDirector());
		response.setBranchAddress(entity.getHubEntity().getBranchEntity().getBranchAddress());
		/*
		if(entity.getMaintenanceHistories() != null) {
			MaintenanceHistoryEntity mHistory = entity.getMaintenanceHistories().get(entity.getMaintenanceHistories().size() - 1);
			response.setMaintenanceResponse(mainConvert.toMaintenanceResponse(mHistory));
		}
		*/
		
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
		response.setDateMaintenance(entity.getDateMaintenance());
		response.setCurrentStatus(entity.getCurrentStatus());
		response.setLatestMaintenanceTime( entity.getLatestMaintenanceTime().toString());
		response.setAlarmMaintenanceStatus(entity.getAlarmMaintenance());
		
		response.setOrderMaintenance(entity.getOrderMaintenance());
		response.setStatusDelete(entity.getStatusDelete());
		
		return response;
	}
	
	public HubDetailAfterChange toHubDetailAfterChange(HubDetailEntity entity) {
		HubDetailAfterChange response = new HubDetailAfterChange();
		response.setHubDetailId(entity.getId());		
		response.setDeviceId(entity.getDevice().getId());
		//response.setDeviceName(entity.getDevice().getDeviceName());
		
		response.setHubId(entity.getHubEntity().getHubId());
		response.setUserModifiedBy(entity.getModifiedBy());
		response.setUserModifiedDate(entity.getModifiedDate().toString());		
		
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
