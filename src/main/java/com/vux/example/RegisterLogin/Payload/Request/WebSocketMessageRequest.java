package com.vux.example.RegisterLogin.Payload.Request;

import com.vux.example.RegisterLogin.Util.EnumAction;
import com.vux.example.RegisterLogin.Util.EnumStatus;

public class WebSocketMessageRequest {

	private String senderName;
    private String receiverName;
    private String message;
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
	public EnumAction getAction() {
		return action;
	}
	public void setAction(EnumAction action) {
		this.action = action;
	}
	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}
    
}
