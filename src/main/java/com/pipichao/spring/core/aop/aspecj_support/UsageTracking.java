package com.pipichao.spring.core.aop.aspecj_support;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;


/**
 *
 * You can make an introduction by using the @DeclareParents annotation.
 * This annotation is used to declare that matching types have a new parent (hence the name).
 * For example, given an interface named UsageTracked and an implementation of that interface named DefaultUsageTracked,
 * the following aspect declares
 * that all implementors of service interfaces also implement the UsageTracked interface
 *
 * */
@Aspect
public class UsageTracking {

    @DeclareParents(value = "com.pipichao.spring.core.aop.*+",defaultImpl = DefaultUsageTracked.class)
    public static UsageTracked mixin;

    @Before(value = "com.pipichao.spring.core.aop.aspecj_support.MyAop.pointcut1() && this(usageTracked)")
    public void recordUsage(UsageTracked usageTracked){

        usageTracked.index();
    }

    /**
     * Note that, in the before advice of the preceding example,
     * service beans can be directly used as implementations of the UsageTracked interface
     * */
}
