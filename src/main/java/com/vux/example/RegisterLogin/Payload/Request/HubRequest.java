package com.vux.example.RegisterLogin.Payload.Request;


public class HubRequest {

	private String hubId;
	private String hubName;
	private String hubAddress;
	private String hubCity;
	
	private Long staffManagerId;
	private Long staffDepartmentId;
	
	private String branchId;
	
	public Long getStaffManagerId() {
		return staffManagerId;
	}
	public void setStaffManagerId(Long staffManagerId) {
		this.staffManagerId = staffManagerId;
	}
	public Long getStaffDepartmentId() {
		return staffDepartmentId;
	}
	public void setStaffDepartmentId(Long staffDepartmentId) {
		this.staffDepartmentId = staffDepartmentId;
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
	
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
}
