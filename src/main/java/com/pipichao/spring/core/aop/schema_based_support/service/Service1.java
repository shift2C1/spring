package com.pipichao.spring.core.aop.schema_based_support.service;

import com.pipichao.spring.core.aop.aspecj_support.anotation.MyAnotation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

public class Service1 {

    public String method1() throws Exception{
        System.out.println("执行了方法1...");
        if (true){
            throw new Exception();
        }
        return "执行了方法1";
    }
    public String method2(Object o1,String s){
        System.out.println("执行了方法2...");
        return "执行了方法2";
    }

    @MyAnotation("")
    public String test(@RequestBody String s){
        return s;
    }
}
