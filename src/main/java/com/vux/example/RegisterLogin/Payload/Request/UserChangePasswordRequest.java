package com.vux.example.RegisterLogin.Payload.Request;

public class UserChangePasswordRequest {

	private String passwordOld;
	private String passwordNew;
	public String getPasswordOld() {
		return passwordOld;
	}
	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	
	
}
