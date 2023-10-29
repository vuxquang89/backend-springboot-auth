package com.vux.example.RegisterLogin.Payload.Response;

public class HubDetailResponseStatus {

	private Integer status;
	private String message;
	private HubDetailResponse response;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HubDetailResponse getResponse() {
		return response;
	}
	public void setResponse(HubDetailResponse response) {
		this.response = response;
	}
	
}
