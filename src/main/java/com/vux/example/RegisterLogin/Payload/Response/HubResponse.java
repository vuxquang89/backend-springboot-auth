package com.vux.example.RegisterLogin.Payload.Response;

import java.util.ArrayList;
import java.util.List;


public class HubResponse {

	private String hubId;
	private String hubName;
	private String hubAddress;
	private String hubCity;
	private String hubManagerName;
	private String hubManagerPhone;
	private UserResponse userResponse;
	private BranchResponse branchResponse;
	private List<HubDetailResponse> hubDetailResponses = new ArrayList<>();
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
	public UserResponse getUserResponse() {
		return userResponse;
	}
	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}
	public BranchResponse getBranchResponse() {
		return branchResponse;
	}
	public void setBranchResponse(BranchResponse branchResponse) {
		this.branchResponse = branchResponse;
	}
	public List<HubDetailResponse> getHubDetailResponses() {
		return hubDetailResponses;
	}
	public void setHubDetailResponses(List<HubDetailResponse> hubDetailResponses) {
		this.hubDetailResponses = hubDetailResponses;
	}
	public void addHubDetailResponse(HubDetailResponse hubDetailResponse) {
		this.hubDetailResponses.add(hubDetailResponse);
	}
}
