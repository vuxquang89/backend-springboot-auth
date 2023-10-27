package com.vux.example.RegisterLogin.Payload.Response;

import java.time.LocalDateTime;
import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;

public class HubDetailResponse {

	private DeviceResponse deviceResponse;
	
	private List<MaintenanceHistoryEntity> maintenanceHistories;
	private String trademark;//thuong hieu	
	private String ratedPower;//cong suat dinh muc
	private String loadDuringPowerOutage;//phan tram tai khi mat dien
	private String batteryQuantity;//so luong pin
	private String batteryNumber;//so chuoi battery hien tai
	private String batteryCapacity;//model(dung luong AH)
	private String productionTime;//thoi gian san xuat
	private String conductorType;//loai day dan
	private String cbPower;//CB nguon
	private String schneider;//cắt lọc sắt
	private String yearInstall;//năm lắp đặt hệ thống điện
	private String number;//số lượng
	private String currentStatus;
	private LocalDateTime latestMaintenanceTime;
	private Integer maintenanceStatus;
	public DeviceResponse getDevice() {
		return deviceResponse;
	}
	public void setDevice(DeviceResponse deviceResponse) {
		this.deviceResponse = deviceResponse;
	}
	
	public List<MaintenanceHistoryEntity> getMaintenanceHistories() {
		return maintenanceHistories;
	}
	public void setMaintenanceHistories(List<MaintenanceHistoryEntity> maintenanceHistories) {
		this.maintenanceHistories = maintenanceHistories;
	}
	public String getTrademark() {
		return trademark;
	}
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	public String getRatedPower() {
		return ratedPower;
	}
	public void setRatedPower(String ratedPower) {
		this.ratedPower = ratedPower;
	}
	public String getLoadDuringPowerOutage() {
		return loadDuringPowerOutage;
	}
	public void setLoadDuringPowerOutage(String loadDuringPowerOutage) {
		this.loadDuringPowerOutage = loadDuringPowerOutage;
	}
	public String getBatteryQuantity() {
		return batteryQuantity;
	}
	public void setBatteryQuantity(String batteryQuantity) {
		this.batteryQuantity = batteryQuantity;
	}
	public String getBatteryNumber() {
		return batteryNumber;
	}
	public void setBatteryNumber(String batteryNumber) {
		this.batteryNumber = batteryNumber;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}
	public String getConductorType() {
		return conductorType;
	}
	public void setConductorType(String conductorType) {
		this.conductorType = conductorType;
	}
	public String getCbPower() {
		return cbPower;
	}
	public void setCbPower(String cbPower) {
		this.cbPower = cbPower;
	}
	public String getSchneider() {
		return schneider;
	}
	public void setSchneider(String schneider) {
		this.schneider = schneider;
	}
	public String getYearInstall() {
		return yearInstall;
	}
	public void setYearInstall(String yearInstall) {
		this.yearInstall = yearInstall;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public LocalDateTime getLatestMaintenanceTime() {
		return latestMaintenanceTime;
	}
	public void setLatestMaintenanceTime(LocalDateTime latestMaintenanceTime) {
		this.latestMaintenanceTime = latestMaintenanceTime;
	}
	public Integer getMaintenanceStatus() {
		return maintenanceStatus;
	}
	public void setMaintenanceStatus(Integer maintenanceStatus) {
		this.maintenanceStatus = maintenanceStatus;
	}
	
}
