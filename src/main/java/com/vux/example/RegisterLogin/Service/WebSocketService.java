package com.vux.example.RegisterLogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Payload.Request.WebSocketMessageRequest;
import com.vux.example.RegisterLogin.Payload.Response.WebSocketMessageResponse;

@Service
public class WebSocketService {
	
//	@Autowired
//	private SimpMessagingTemplate simpMessagingTemplate;
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}
	
	public void notifyFrontend(String to, WebSocketMessageResponse message) {
		simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
	}
	
	public void sendMessage(WebSocketMessageResponse message) {
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
	}
	
//	public void notifyFrontend(String to, WebSocketMessageResponse message) {
//		simpMessagingTemplate.convertAndSend("/group/" + to, message);
//	}
	
//	public void sendMessage(WebSocketMessageResponse message) {
//		simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/specific",message);
//	}

}
