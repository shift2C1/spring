package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.handlermethods;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class RequestBodyController {

    /**
     * 使用@RequestBody  注解需要先配置一个消息转换器
     * 否则 415 媒体类型不对
     * */
    @PostMapping("/getRequestBody")
    @ResponseBody
    public String getRequestBody( @RequestBody Pet pet){
        System.out.println(pet);
        return pet.toString();
    }

    @PostMapping("/getHttpEntity")
    @ResponseBody
    public void getHttpEntity(HttpEntity<Pet> entity){//返回值类型必须为 void
        System.out.println(entity);// 请求头 + 实体类（请求体中）一起返回
//        return pet.toString();
        HttpHeaders httpHeaders=entity.getHeaders();
//        System.out.println(httpHeaders);
        new ArrayList<String>(httpHeaders.keySet()).stream().forEach(key->{
            System.out.println(key+"--------");
            httpHeaders.get(key).forEach(index->{
                System.out.println(index);
            });
        });
        if (entity.hasBody()){
            Pet pet=entity.getBody();
            System.out.println(pet);
        }
    }
    @GetMapping("/something")
    public ResponseEntity<String> handle() {
        String body ="hah" ;
        String etag = "heh" ;
//        return ResponseEntity.ok().eTag(etag).build(body);//来自官网，报错
        return ResponseEntity.ok().eTag(etag).body(body);
    }

}
