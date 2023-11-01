package com.vux.example.RegisterLogin.Payload.Response;

public class HubDetailAlarmResponse {

	private long hubDetailId;
	private Long deviceId;
	private String deviceName;
	
	private String hubId;
	private String hubName;
	
	private String branchId;	
	private String branchName;
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
	
}
