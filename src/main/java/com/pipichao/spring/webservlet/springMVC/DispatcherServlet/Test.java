package com.pipichao.spring.webservlet.springMVC.DispatcherServlet;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 测试类：检测配置是否被注入
 *
 * */

@Controller
@RequestMapping("/test")
public class Test {
    @RequestMapping("/test")
    public void test(){
//        LocaleResolver
    }
}
