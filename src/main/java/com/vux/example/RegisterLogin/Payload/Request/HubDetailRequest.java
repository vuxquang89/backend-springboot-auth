package com.vux.example.RegisterLogin.Payload.Request;

public class HubDetailRequest {

	private Long deviceId;
	private String hubId;
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
	private String currentStatus;//tinh trang
	private Integer dateMaintenance;//so ngay bao duong
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public String getHubId() {
		return hubId;
	}
	public void setHubId(String hubId) {
		this.hubId = hubId;
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
	public Integer getDateMaintenance() {
		return dateMaintenance;
	}
	public void setDateMaintenance(Integer dateMaintenance) {
		this.dateMaintenance = dateMaintenance;
	}
	
	
}
