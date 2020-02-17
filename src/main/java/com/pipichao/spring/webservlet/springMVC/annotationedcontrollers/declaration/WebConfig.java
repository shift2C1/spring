package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.declaration;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.format.*;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.FilterRegistration;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Configuration
//@ComponentScan("com.pipichao.spring.webservlet.springMVC.annotationedcontrollers")
@ComponentScan("com.pipichao.spring.webservlet.springMVC")
@EnableWebMvc///相当于在springmvc.xml中开启注解驱动
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer

    }

    /**
     * 主要操作媒体类型
     * */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.mediaType("json",MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(3000);
        AsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor();
        configurer.setTaskExecutor(asyncTaskExecutor);
    }

    /**
     * 处理一些静态资源主要用于
     * */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    /**
     * 格式转换器
     * */
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        AnnotationFormatterFactory<? extends Annotation> annotationFormatterFactory=new DateTimeFormatAnnotationFormatterFactory();

//        registry.addFormatterForFieldAnnotation(annotationFormatterFactory);
//        Formatter<?> formatter ;
//        Printer<?> printer = ;
//        registry.addPrinter(printer);
//        Parser<?> parser = ;
//        registry.addParser(parser);
//        registry.addFormatter(formatter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        HandlerInterceptor handlerInterceptor;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
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
        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
//        FastJsonConfig config=new FastJsonConfig();
        List<MediaType> list=new ArrayList<>();

        list.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(list);
        converters.add(converter);
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
