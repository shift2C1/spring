package com.pipichao.spring.dataaccess.transactionmanagement.anotationbased;

import com.pipichao.spring.dataaccess.transactionmanagement.anotationbased.anotation.Tx1;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyService {

    @Transactional(value = "tx1") //配合事务注解驱动（<tx:annotation-driven >）使用
    public void TestAnotationDriver(){

    }
    @Transactional(propagation = Propagation.REQUIRED,value = "tx2")//方法级别的优先级要高于类级别的事务管理
    public void TestAnotationDriver1(){

    }


    /**
     * //    当我们需要多次使用该类型的注解时 spring 对元注解的支持可以简化开发
     * //    自定义我们的事务注解
     * */
    @Tx1
    public String test1(){
        return "";
    }
}
