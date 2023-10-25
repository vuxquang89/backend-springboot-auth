package com.vux.example.RegisterLogin.Payload.Request;


public class BranchRequest {

	private String branchId;	
	private String branchName;	
	private String deputyTechnicalDirector;	
	private String phoneDeputyTechnicalDirector;
	private String emailDeputyTechnicalDirector;
	private String branchAddress;
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
	
}
