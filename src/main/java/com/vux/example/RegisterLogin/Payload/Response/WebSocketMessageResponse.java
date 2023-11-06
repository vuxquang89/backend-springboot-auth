package com.vux.example.RegisterLogin.Payload.Response;

import com.vux.example.RegisterLogin.Util.EnumAction;
import com.vux.example.RegisterLogin.Util.EnumStatus;

public class WebSocketMessageResponse {

	private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private EnumStatus status;
    private EnumAction action;
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	public EnumAction getAction() {
		return action;
	}
	public void setAction(EnumAction action) {
		this.action = action;
	}
	
    
}
