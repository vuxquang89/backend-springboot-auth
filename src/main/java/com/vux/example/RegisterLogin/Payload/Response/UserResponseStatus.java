package com.vux.example.RegisterLogin.Payload.Response;

import java.util.ArrayList;
import java.util.List;

public class UserResponseStatus {

	private Integer status;
	private String message;
	private List<UserResponse> responses = new ArrayList<UserResponse>();
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
	public List<UserResponse> getResponses() {
		return responses;
	}
	public void setResponses(List<UserResponse> responses) {
		this.responses = responses;
	}
	public void addUserResponse(UserResponse response) {
		this.responses.add(response);
	}
}
