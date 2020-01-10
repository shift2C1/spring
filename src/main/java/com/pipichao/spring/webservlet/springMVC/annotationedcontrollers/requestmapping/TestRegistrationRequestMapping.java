package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

//@Configuration
public class TestRegistrationRequestMapping {

    /**
     * 手动注册一个 RequestMapping
     * */
    /*
        注入失败？？？？？
    /
     */
    @Autowired
    public void setHandlerMapping(RequestMappingHandlerMapping requestMappingHandlerMapping,PersonController handler){
        try {
            //指定 请求的路径 、方法
            RequestMappingInfo info=RequestMappingInfo.paths("/saveParam").methods(RequestMethod.GET).build();
            //获取业务逻辑方法
            Method method=PersonController.class.getMethod("saveParam");
            //注册controller
            requestMappingHandlerMapping.registerMapping(info,handler,method);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
