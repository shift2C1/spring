package com.pipichao.spring.webservlet.websockets.stomp;

import com.pipichao.spring.webservlet.websockets.websocketAPI.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;

//@Configuration
//@EnableWebSocketMessageBroker
public class StompWebSocketConfig extends WebSocketMessageBrokerConfigurationSupport {
    @Override
    protected void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/portfolio").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic", "/queue");
    }
//    @Bean
//    public MyHandler getMyhandler(){
//        return new MyHandler();
//    }
}
