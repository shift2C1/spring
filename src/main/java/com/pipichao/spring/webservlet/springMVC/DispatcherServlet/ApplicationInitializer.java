package com.pipichao.spring.webservlet.springMVC.DispatcherServlet;

import com.pipichao.spring.webservlet.springMVC.DispatcherServlet.AppConfig;
import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.declaration.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 相当于在 web.xml 中配置
 *
 * spring在初始化的时候会扫描 所有实现 WebApplicationInitializer 的实现类
 * 自动调用 onStartup 方法，初始化容器
 * */

/**
 * <!--servlet3.0 及之前的版本在 web.xml中配置 在之后提出了 java 为基础的配置方式 -->
 * */
//@Slf4j
public class ApplicationInitializer implements WebApplicationInitializer {
    /**初始化的时候会接收 servlet 全局对象*/
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        log.info("初始化web容器。。。");
        System.out.println("初始化web容器。。。");
        /*
        * 注册spring 容器
        * */
        AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebConfig.class);
        webApplicationContext.setServletContext(servletContext);//必须设置servlet全局上下文
        // 否则在@EnableWebMvc注解启动时会报错：servlet全局上下文找不到
        webApplicationContext.refresh();


        DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);
        /**
         * web 上下文 类（ConfigurableWebApplicationContext 的子类）
         *
         * 默认是 XmlWebApplicationContext
         *
         * 以上实例化前置控制器时构造器的 参数 也是 ConfigurableWebApplicationContext 的子实现
         * */
//        dispatcherServlet.setContextClass();
        /**
         * web 上下文配置文件路径
         *  在web.xml（在这里设置也一样） 中 如果存在多个 配置文件路径 则 用 【，】隔开
         *  当多个相同的 配置文件被加载后 spring 会 取最新的
         * */
//        dispatcherServlet.setContextConfigLocation();
        /**
         * WebApplicationContext 的命名空间 ： 默认是 servlet 的名字
         * */
//        dispatcherServlet.setNamespace();

        /**
         * 是否抛出一个 NoHandlerFoundException  异常 ，当请求没有所映射的处理器时候
         * 这个异常将会被 HandlerExceptionResolver 捕捉到（eg: 使用了@ExceptionHandler为注解的controller 方法）
         *
         * 默认 情况是 false 这是 前置控制器会响应 404 http状态码
         *
         * Note that, if default servlet handling is also configured,
         * unresolved requests are always forwarded to the default servlet and a 404 is never raised.
         *
         * 【注意：】 如果一个默认的servlet被配置了 ,未处理的请求 总会被映射到默认的servlet
         *  404 永远不会出现
         * */
//        dispatcherServlet.setThrowExceptionIfNoHandlerFound();

        ServletRegistration.Dynamic registration=servletContext.addServlet("dispatcherServlet",dispatcherServlet);
        registration.addMapping("/app/*");
        registration.setLoadOnStartup(1);
//        FilterRegistration.Dynamic corFilter = servletContext.addFilter("corFilter", new DomainFilter());
//        corFilter.addMappingForServletNames(null,false,"dispatcherServlet");
    }
}
