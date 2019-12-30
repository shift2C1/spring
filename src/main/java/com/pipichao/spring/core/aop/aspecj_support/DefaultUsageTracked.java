package com.pipichao.spring.core.aop.aspecj_support;

public class DefaultUsageTracked implements UsageTracked {
    @Override
    public void index() {
        System.out.println("执行子实现方法");
    }
}
