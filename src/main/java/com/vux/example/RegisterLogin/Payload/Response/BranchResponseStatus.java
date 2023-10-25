package com.vux.example.RegisterLogin.Payload.Response;

public class BranchResponseStatus {

	private Integer status;
	private String message;
	private BranchResponse response;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BranchResponse getResponse() {
		return response;
	}
	public void setResponse(BranchResponse response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
