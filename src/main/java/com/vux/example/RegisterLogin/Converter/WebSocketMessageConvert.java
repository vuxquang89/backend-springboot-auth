package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Payload.Request.WebSocketMessageRequest;
import com.vux.example.RegisterLogin.Payload.Response.WebSocketMessageResponse;

@Component
public class WebSocketMessageConvert {

	public WebSocketMessageResponse toResponse(WebSocketMessageRequest request) {
		WebSocketMessageResponse response = new WebSocketMessageResponse();
		response.setSenderName(request.getSenderName());
		response.setStatus(request.getStatus());
		response.setContent(request.getContent());
		response.setReceiverName(request.getReceiverName());
		response.setMessage(request.getMessage());
		response.setAction(request.getAction());
		return response;
	}
}
