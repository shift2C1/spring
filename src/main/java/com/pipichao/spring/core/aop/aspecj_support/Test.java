package com.pipichao.spring.core.aop.aspecj_support;

import com.pipichao.spring.core.aop.aspecj_support.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception{
        ApplicationContext ioc=new ClassPathXmlApplicationContext("ioc.xml");
        Myclass myclass=ioc.getBean(Myclass.class);
        myclass.method1(new Object());
        myclass.validationAccount(new Account());
        myclass.useAuditble();

        //相当 Myclass asle实现了 UsageTracked 接口,Myclass 能直接当成 UsageTracked 的子实现来use
//        UsageTracked usageTracked=(UsageTracked)ioc.getBean(Myclass.class);
//        usageTracked.index();
    }
}
