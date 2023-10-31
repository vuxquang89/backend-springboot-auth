package com.vux.example.RegisterLogin.Payload.Response;

public class MaintenanceHistoryResponseStatus {
	
	private int status;
	private String message;
	private MaintenanceHistoryResponse response;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MaintenanceHistoryResponse getResponse() {
		return response;
	}
	public void setResponse(MaintenanceHistoryResponse response) {
		this.response = response;
	}
	

}
