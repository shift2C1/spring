package com.pipichao.spring.core.aop.schema_based_support.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void beforeEg(Object param){
        System.out.println("接收的参数："+param);//this（） 接受被切面代理的对象？这里是Service1这个类？
//        com.pipichao.spring.core.aop.schema_based_support.service.Service1@3da30852
        System.out.println("before 切面正在执行。。。");
    }

    public void afterReturningEg(Object retVal){
        System.out.println("afterReturning 切面正在执行");
        System.out.println("接收到的返回值："+retVal);
    }

    public void afterThrowingEg(Exception ex){
        ex.printStackTrace();
    }

    public void afterEg(){
        System.out.println("after切面正在执行。。。");
    }

    public Object aroundEg(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around切面正在执行。。。");
//        for (Object p:param
//             ) {
//            System.out.println("参数："+p);
//        }
        Object retVal=joinPoint.proceed();
        System.out.println("around返回参数："+retVal);
        return retVal;
    }
}
