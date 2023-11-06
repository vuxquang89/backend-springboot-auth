package com.vux.example.RegisterLogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.DateTimeConvert;
import com.vux.example.RegisterLogin.Converter.WebSocketMessageConvert;
import com.vux.example.RegisterLogin.Payload.Request.WebSocketMessageRequest;
import com.vux.example.RegisterLogin.Payload.Response.WebSocketMessageResponse;
import com.vux.example.RegisterLogin.Service.HubDetailService;
import com.vux.example.RegisterLogin.Service.WebSocketService;
import com.vux.example.RegisterLogin.Util.EnumAction;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MessageController {
	@Autowired
	private WebSocketService webSocketService;
	@Autowired
	private DateTimeConvert dateTimeConvert;
	@Autowired
	private WebSocketMessageConvert wsMessageConvert;
	@Autowired
	private HubDetailService hubDetailService;
	
//	@MessageMapping("/application")
//    @SendTo("/all/messages")
//    public WebSocketMessageResponse send(final WebSocketMessageResponse message){
//		System.out.println("user join");
//		System.out.println(message.getSenderName());
//        return message;
//    }
	
	@MessageMapping("/message")
    @SendTo("/chatroom/public")
    public WebSocketMessageResponse receiveMessage(@Payload WebSocketMessageRequest message){
		WebSocketMessageResponse response = wsMessageConvert.toResponse(message);
		System.out.println("user join");
		System.out.println(message.getSenderName());
		Integer countAlarm = hubDetailService.getCountAlarm(message.getSenderName());
		response.setMessage(String.valueOf(countAlarm));
        return response;
    }
	
	@MessageMapping("/private-message")
    public WebSocketMessageResponse recMessage(@Payload WebSocketMessageRequest request){
		WebSocketMessageResponse response = wsMessageConvert.toResponse(request);
		response.setDate(dateTimeConvert.nowString());
		if(request.getAction() == EnumAction.EDIT_MAINTENANCE || request.getAction() == EnumAction.GET_ALARM) {
			Integer countAlarm = hubDetailService.getCountAlarm(request.getSenderName());
			response.setMessage(String.valueOf(countAlarm));
			
		}
    	webSocketService.sendMessage(response);
    	
		//wsService.notifyFrontend(to, message);
        return response;
    }
	
//	@MessageMapping("/message")
//	@SendTo("/group/public")
//	public WebSocketMessageResponse reciveMessage(@Payload WebSocketMessageResponse message) {
//		webSocketService.notifyFrontend(message.getReceiverName(), message);
//		return message;
//	}

//	@MessageMapping("/private")
//    public void sendToSpecificUser(@Payload WebSocketMessageResponse message) {
//		message.setDate(dateTimeConvert.nowString());
//		System.out.println("user send message");
//		System.out.println(message.getReceiverName());
//		//get datatabase
//		webSocketService.sendMessage(message);
//		
//    }
}
