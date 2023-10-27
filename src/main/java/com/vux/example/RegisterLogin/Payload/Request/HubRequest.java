package com.vux.example.RegisterLogin.Payload.Request;


public class HubRequest {

	private String hubId;
	private String hubName;
	private String hubAddress;
	private String hubCity;
	private String hubManagerName;
	private String hubManagerPhone;
	private Long userId;
	private String branchId;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
}
