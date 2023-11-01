package com.vux.example.RegisterLogin.Payload.Response;


public class HubDetailUserResponse {

	private long hubDetailId;
	private Long deviceId;
	private String deviceName;
	private String backgroundColor;

	private String hubId;
	private String hubName;
	private String hubAddress;
	private String hubCity;
	private String hubManagerName;
	private String hubManagerPhone;
	
	private long userId;
	private String username;
	private String email;
	private String fullname;
	private String phone;
	
	private String branchId;	
	private String branchName;	
	private String deputyTechnicalDirector;	
	private String phoneDeputyTechnicalDirector;
	private String emailDeputyTechnicalDirector;
	private String branchAddress;	
	
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
	private String latestMaintenanceTime;
	private Integer alarmMaintenanceStatus;
	private MaintenanceResponse maintenanceResponse = new MaintenanceResponse();
	public long getHubDetailId() {
		return hubDetailId;
	}
	public void setHubDetailId(long hubDetailId) {
		this.hubDetailId = hubDetailId;
	}
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getHubId() {
		return hubId;
	}
	public void setHubId(String hubId) {
		this.hubId = hubId;
	}
	public String getHubName() {
		return hubName;
	}
	public void setHubName(String hubName) {
		this.hubName = hubName;
	}
	public String getHubAddress() {
		return hubAddress;
	}
	public void setHubAddress(String hubAddress) {
		this.hubAddress = hubAddress;
	}
	public String getHubCity() {
		return hubCity;
	}
	public void setHubCity(String hubCity) {
		this.hubCity = hubCity;
	}
	public String getHubManagerName() {
		return hubManagerName;
	}
	public void setHubManagerName(String hubManagerName) {
		this.hubManagerName = hubManagerName;
	}
	public String getHubManagerPhone() {
		return hubManagerPhone;
	}
	public void setHubManagerPhone(String hubManagerPhone) {
		this.hubManagerPhone = hubManagerPhone;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getDeputyTechnicalDirector() {
		return deputyTechnicalDirector;
	}
	public void setDeputyTechnicalDirector(String deputyTechnicalDirector) {
		this.deputyTechnicalDirector = deputyTechnicalDirector;
	}
	public String getPhoneDeputyTechnicalDirector() {
		return phoneDeputyTechnicalDirector;
	}
	public void setPhoneDeputyTechnicalDirector(String phoneDeputyTechnicalDirector) {
		this.phoneDeputyTechnicalDirector = phoneDeputyTechnicalDirector;
	}
	public String getEmailDeputyTechnicalDirector() {
		return emailDeputyTechnicalDirector;
	}
	public void setEmailDeputyTechnicalDirector(String emailDeputyTechnicalDirector) {
		this.emailDeputyTechnicalDirector = emailDeputyTechnicalDirector;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
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
	public String getLatestMaintenanceTime() {
		return latestMaintenanceTime;
	}
	public void setLatestMaintenanceTime(String latestMaintenanceTime) {
		this.latestMaintenanceTime = latestMaintenanceTime;
	}
	public Integer getAlarmMaintenanceStatus() {
		return alarmMaintenanceStatus;
	}
	public void setAlarmMaintenanceStatus(Integer alarmMaintenanceStatus) {
		this.alarmMaintenanceStatus = alarmMaintenanceStatus;
	}
	public MaintenanceResponse getMaintenanceResponse() {
		return maintenanceResponse;
	}
	public void setMaintenanceResponse(MaintenanceResponse maintenanceResponse) {
		this.maintenanceResponse = maintenanceResponse;
	}
	
	
}
