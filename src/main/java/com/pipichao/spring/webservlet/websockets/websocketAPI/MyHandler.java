package com.pipichao.spring.webservlet.websockets.websocketAPI;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.WebSocketHttpRequestHandler;

/**
 * websocket 服务器端
 *
 * BinaryWebSocketHandler,
 * WebSocketHandler
 * */
public class MyHandler extends TextWebSocketHandler {
    public MyHandler(){
        System.out.println("初始化websocket处理器");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("建立了websocket连接");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        super.handleTextMessage(session, message);
        System.out.println("正在访问websocket 服务器");
        System.out.println("收到的消息"+message);
        session.sendMessage(message);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("断开了websocket连接");
    }
//    WebSocketHttpRequestHandler webSocketHttpRequestHandler=new WebSocketHttpRequestHandler(new MyHandler());
//    WebSocketSession webSocketSession;
//    ConcurrentWebSocketSessionDecorator decorator;
}
