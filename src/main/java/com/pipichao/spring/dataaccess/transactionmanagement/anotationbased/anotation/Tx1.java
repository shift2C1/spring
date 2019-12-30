package com.pipichao.spring.dataaccess.transactionmanagement.anotationbased.anotation;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Transactional(value = "tx1")//关联到ioc里的tx1事务管理器
@Retention(RetentionPolicy.RUNTIME)
public @interface Tx1 {
//    当我们需要多次使用该类型的注解时 spring 对元注解的支持可以简化开发
//    自定义我们的事务注解
}
