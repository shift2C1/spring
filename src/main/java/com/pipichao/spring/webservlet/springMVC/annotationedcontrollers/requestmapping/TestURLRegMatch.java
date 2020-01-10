package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The syntax {varName:regex} declares a URI variable with a regular expression that has syntax of {varName:regex}.
 * For example,given URL "/spring-web-3.0.5 .jar", the following method extracts the name, version, and file extension:
 *
 * 符号 {变量名：正则表达式} 申明一个带有正则表达式的请求路径
 * 比如我们访问 /spring-web-3.0.5 .jar 这个路径
 */
@RestController
public class TestURLRegMatch {
    /**
     * 一下路径匹配：
     *              name：至少一个字母，一个 【-】 ，
     *              version：一个数字，一个【.】,一个数字，一个【.】,一个数字
     *              ext：一个【.】，至少一个字母
     *
     * */
//    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")//自己写
    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")//官网  都404
    public void handle(@PathVariable("name")String name,@PathVariable String version,@PathVariable("ext")String ext){
        System.out.println("name:"+name);
        System.out.println("version:"+version);
        System.out.println("ext:"+ext);
    }
}
