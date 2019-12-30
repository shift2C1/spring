package com.pipichao.spring.dataaccess.transactionmanagement.xmlbased;

import com.pipichao.spring.dataaccess.transactionmanagement.anotationbased.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boot {
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc.xml");
        MyService fooService = (MyService) ctx.getBean(MyService.class);
        fooService.TestAnotationDriver1();
    }
}
