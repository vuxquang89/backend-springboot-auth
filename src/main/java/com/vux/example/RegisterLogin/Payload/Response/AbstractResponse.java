package com.vux.example.RegisterLogin.Payload.Response;

import java.util.ArrayList;
import java.util.List;

public class AbstractResponse<T> {

	private int status;
	private List<T> response = new ArrayList<T>();
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<T> getResponse() {
		return response;
	}
	public void setResponse(List<T> response) {
		this.response = response;
	}
	
	
}
