package com.pipichao.spring.core.aop.aspecj_support;

import com.pipichao.spring.core.aop.aspecj_support.anotation.Auditble;
import com.pipichao.spring.core.aop.aspecj_support.anotation.MyAnotation;
import com.pipichao.spring.core.aop.aspecj_support.entity.Account;

@MyAnotation("class anotation")
public class Myclass {

    @MyAnotation("method anotation")
   public String method1(Object o) throws Exception{
//       do something
        System.out.println("执行了目标方法");
//        if (true){
//            throw new Exception();
//        }


        return "哈哈哈";
   }

   public String validationAccount(Account account){
       System.out.println("正在验证。。。");
        return "验证完成";
   }

   public String validationAccount(Object o){
        return "";
   }

   @Auditble("code")
    public String useAuditble(){
        return "使用了Auditble注解";
   }
}
