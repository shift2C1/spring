package com.pipichao.spring.core.aop.schema_based_support;

import com.pipichao.spring.core.aop.schema_based_support.service.Service1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPSchemaBasedTest {
    public static void main(String[] args) {
        ApplicationContext ioc= new ClassPathXmlApplicationContext("aop_schema.xml");
        Service1 service1=ioc.getBean(Service1.class);
//        try {
//            service1.method1();
//        } catch (Exception e) {
////            e.printStackTrace();
//            System.out.println("打印异常信息。。。");
//        }
        service1.test("hah");
    }
}
