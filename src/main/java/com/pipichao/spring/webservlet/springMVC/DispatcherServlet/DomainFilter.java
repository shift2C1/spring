package com.pipichao.spring.webservlet.springMVC.DispatcherServlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Slf4j
//@WebFilter(urlPatterns ={"/*"})
//@Order(1)
public class DomainFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
//     log.info("app 域名过滤器初始化");
        System.out.println("app 域名过滤器初始化");
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
