package com.pipichao.spring.webservlet.websockets.websocketAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * websocket配置
 * 向spring注册websocket服务
 *
 * 也可以在xml中配置
 * 见：websockets.xml文件
 *
 * */

//@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.
                addHandler(this.getMyHandler(),"/portfolio").
                addInterceptors(this.httpSessionHandshakeInterceptor());
//                .setAllowedOrigins();跨域
//                        .withSockJS().setClientLibraryUrl("http://localhost:8080/myapp/js/sockjs-client.js").
//                        setHeartbeatTime(23);//使能sockjs 设置sockjs位置,设置心跳检测时间
        //一系列配置
    }

//    @Bean
    private MyHandler getMyHandler(){
        return new MyHandler();
    }

    private HttpSessionHandshakeInterceptor httpSessionHandshakeInterceptor(){
        HttpSessionHandshakeInterceptor httpSessionHandshakeInterceptor=new HttpSessionHandshakeInterceptor();
        //进行一系列操作
        //        httpSessionHandshakeInterceptor.
        return httpSessionHandshakeInterceptor;
    }
}
