package com.vux.example.RegisterLogin.Payload.Response;

public class HubResponseStatus {

	private Integer status;
	private String message;
	private HubResponse hubResponse;
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
	public HubResponse getHubResponse() {
		return hubResponse;
	}
	public void setHubResponse(HubResponse hubResponse) {
		this.hubResponse = hubResponse;
	}
	
}
