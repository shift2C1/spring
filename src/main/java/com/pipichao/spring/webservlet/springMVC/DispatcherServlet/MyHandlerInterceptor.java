package com.pipichao.spring.webservlet.springMVC.DispatcherServlet;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 自定义处理器拦截器
 *
 * */
public class MyHandlerInterceptor implements HandlerInterceptor {
    /**
     *在真正的处理器执行之前
     *
     * 这个方法返回 布尔值，通过这个值我们可以决定是否继续执行 执行链 。
     * 当返回 true 的时候，处理器执行链继续，当返回 false 的时候 前置控制器假设拦截器本身已经处理好了请求（比如渲染了一个视图），
     * 并且不再执行处理器执行链中的拦截器和处理器
     * */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    /**
     * 处理器执行之后
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求完成后
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
