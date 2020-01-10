package com.pipichao.spring.webservlet.springMVC.DispatcherServlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
* web上下文的层级
* */

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        /**
         * 相当于配置 spring全局文件
         * web.xml中配置 spring监听器 和上下文路径
         * */
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        /**
         * 相当于配置 DispatcherServlet 的配置文件
         * 相当于web.xml 中配置 前置控制器初始化参数 ：init-param
         * */
        return new Class[]{App1Config.class};
    }

    @Override
    protected String[] getServletMappings() {
        /**
         * 前置控制器拦截路径
         * */
        return new String[]{"/app1/*"};
    }

    /**
     * 添加过滤器
     * 会自动映射到 前置控制器
     *
     * */
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }

    /***/

}
