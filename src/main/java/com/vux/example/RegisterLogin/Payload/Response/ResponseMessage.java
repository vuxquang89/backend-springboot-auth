package com.vux.example.RegisterLogin.Payload.Response;

public class ResponseMessage {

	private int status;
	private String message;
	
	public ResponseMessage() {}

	public ResponseMessage(String message) {
		
		this.message = message;
	}

	public ResponseMessage(int status, String message) {
		this.status = status;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
