package com.pipichao.spring.core.aop.aspecj_support;

import com.pipichao.spring.core.aop.aspecj_support.anotation.Auditble;
import com.pipichao.spring.core.aop.aspecj_support.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAop {
    @Pointcut(value = "execution(public * com.pipichao.spring.core.aop..methodName(..))")
    public void pointcut1(){//返回值必须为空

    }

//    @Pointcut(value = "within(cm.pipicha.spring.core)")
//    public void pointcut2(){
//
//    }

//    @Pointcut(value = "pointcut1() && pointcut2()") //两者同时满足，其他相关操作符还有：|| ,!
//    public void pointcut3(){
//
//    }

//
    /**
     * execution 表达式
     *   execution(     modifiers-pattern?
     *                  ret-type-pattern
     *                  declaring-type-pattern?
     *                  name-pattern(param-pattern)
     *                 throws-pattern?
     *             )
     *  修饰符模式？ 返回值类型模式 声明类型？ 名字模式（参数模式） 抛出异常模式
     *
     *  修饰符模式：访问控制修饰符
     *  声明类型：类的名字
     * */

    @Before(value = "pointcut1()))")
    public void beforeMethod(JoinPoint joinPoint){
        try {
            Signature signature=joinPoint.getSignature();
//        Method method=signature.getDeclaringType().getMethod("");
//        MyAnotation myAnotation=method.getAnnotation(MyAnotation.class);
//            System.out.println("signature:"+signature);
//            Class clazz=signature.getDeclaringType();
//            String className=signature.getDeclaringTypeName();
//            System.out.println("clazz:"+clazz);
//            Annotation annotation = clazz.getAnnotation(MyAnotation.class);
//            System.out.println("annotation:"+annotation);
//            Method method= null;

//            method = clazz.getDeclaredMethod("method1");

//            MyAnotation myAnotation=method.getAnnotation(MyAnotation.class);
//            System.out.println("method anotation"+myAnotation);
            System.out.println("执行了。。。 beforeMethod");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @AfterReturning(pointcut = "pointcut1()",returning = "re")//returning的值必须和方法的参数名字对应
    public void testAfterReturning(Object re){
        System.out.println("返回的数据:"+re);
        System.out.println("在return之后执行");
    }
    @AfterThrowing(pointcut = "pointcut1()",throwing = "ex")//throwing的值必须和方法的参数名字对应
    public void testAfterThrowing(Exception ex){
        System.out.println("在切面打印异常信息");
        ex.printStackTrace();
        System.out.println("抛出异常之后执行");
    }

    @After(value = "pointcut1()")
    public void testAfter(){
        System.out.println("test after执行");
    }

    @Around(value = "pointcut1()")
    public Object testAround(ProceedingJoinPoint joinPoint) throws Throwable{ //第一个参数必须是 ProceedingJoinPoint 类型
        System.out.println("around 执行");

        Object retVal=joinPoint.proceed();
        System.out.println("retVal:"+retVal);
        return retVal;
    }

/**
 * 执行顺序
 *
 * 1、执行了。。。 beforeMethod ：@before
 * 2、执行了目标方法  ：真正的目标方法
 * 3、test after执行 ：：@after
 * 4、返回的数据:哈哈哈 ：@afterreturning
 * 5、在return之后执行
 *
 *
 * */


/**
 *
 * 参数绑定
 *
 *
 * **/
    @Pointcut(value = "execution(public * com.pipichao.spring.core.aop..*(..) ) && args(account,..)")
    public void pointcut2(Account account){

    }
    @Before(value = "pointcut2(param)")
    public void testParamBind(Account param){
        System.out.println("account:"+param);
    }

    @Before(value = "execution(public * com.pipichao.spring.core.aop..*(..)) && @annotation(auditble)))")
    public void testAnotationBind(Auditble auditble){
        String v=auditble.value();
        System.out.println("注解的参数值："+v);
    }

    /**
     * 泛型的支持
     *
     * */
//    @Before("execution(* ..Sample+.sampleGenericCollectionMethod(*)) && args(param)")
//    public void testGeneric(Collection<Account> param){
//
//    }
    /**
     * 关于参数命名
     * */

}
