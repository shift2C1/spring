package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.declaration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan("com.pipichao.spring.webservlet.springMVC.annotationedcontrollers")
@EnableWebMvc///相当于在springmvc.xml中开启注解驱动
public class WebConfig implements WebMvcConfigurer {
    /**
     * 我们可以定义controller类 通过使用标准的spring bean 定义 在servlet 的 WebApplicationContext，
     *
     * @Controller 容许自动检测，和spring 对@ComponentScan 的支持一样，spring会自动检测他们并且会自动定义他们
     *
     * 指明他们是web的组件
     *
     * */
    /**
     * @ComponentScan("com.pipichao.spring.webservlet") 的作用就向在spring 的xml配置文件中定义：
     * <context:component-scan base-package="org.example.web"/> 标签
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter());
    }
    /**
     * 不能够见简单的注入spring
     * 必须得让web容器识别
     * 就像在xml文件中消息转换器必须配置在注解驱动里
     * */
    //    public HttpMessageConverter jsonbHttpMessageConverter(){
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
////        httpMessageConverters.add(fastJsonHttpMessageConverter);
//        return fastJsonHttpMessageConverter;
//    }

}
