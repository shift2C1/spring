package com.pipichao.spring.core.ioc;

import com.pipichao.spring.core.ioc.RootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc =new AnnotationConfigApplicationContext(RootConfig.class);
//        ioc.refresh();
        ioc.getBean("string");
        ioc.close();


    }
}
