package com.pipichao.spring.webservlet.springMVC.DispatcherServlet;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 测试类：检测配置是否被注入
 *
 * */

@Controller
@RequestMapping("/test")
public class Test {
    @RequestMapping("/getTestData")
    @ResponseBody
    public String test(){
//
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","success");
        jsonObject.put("code","0");
        return jsonObject.toJSONString();
    }

    public static void main(String[] args) {
        System.out.println("hahha");
    }
}
