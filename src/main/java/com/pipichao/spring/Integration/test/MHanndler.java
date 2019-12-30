package com.pipichao.spring.Integration.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MHanndler {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        System.out.println("cming");
        return "welcme";
    }
}
