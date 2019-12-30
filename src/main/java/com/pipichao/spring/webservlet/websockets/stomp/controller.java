package com.pipichao.spring.webservlet.websockets.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

//@Controller
//@MessageMapping("/app")
public class controller {
//    @MessageMapping("/login")
    public String login(){
        System.out.println("正在登陆。。。");
        return "登录成功";
    }
}
