package com.vux.example.RegisterLogin.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Value("${app.cors.allowedOrigins}")
    private String[] allowedOrigins;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/ws");
//		registry.addEndpoint("/ws").withSockJS();
		registry.addEndpoint("/chat")
			.setAllowedOrigins(allowedOrigins)
			.withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.enableSimpleBroker("/all","/specific");		
//        registry.setUserDestinationPrefix("/user");
//		registry.setApplicationDestinationPrefixes("/app");
		
//		registry.enableSimpleBroker("/group","/user");
//		registry.setApplicationDestinationPrefixes("/app");
//		registry.setUserDestinationPrefix("/user");
		
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/chatroom","/user");
        registry.setUserDestinationPrefix("/user");
	}
}
