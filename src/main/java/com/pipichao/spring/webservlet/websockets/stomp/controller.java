package com.pipichao.spring.webservlet.websockets.stomp;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
//@MessageMapping("/app")
public class controller {
    @MessageMapping("/login")//默认前面加/app
//    @SendTo
//    @SendToUser
    public String login(@DestinationVariable("login") String login){
        System.out.println("收到的消息:"+login);
        System.out.println("正在登陆。。。");
        return "登录成功";
    }

}
