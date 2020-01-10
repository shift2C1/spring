package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    /*
    * 访问：http://localhost:8074/app/person/1001 ：容器初始化器在 DispatcherServlet 包下
    * */
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id")String id){
        System.out.println("personId:"+id);
        return null;
    }

    /*
    *http://localhost:8074/app/person
    * 请求体中添加 json参数 会自动映射到这里
    * 这里报415 由于没有配置json解析(如果参数是String 类型则可以)
    *
    * */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Person person){
        System.out.println(person);
    }


    /**
     * 该方法没有实际意义
     * 测试手动注册 RequestMapping
     * */
    public void saveParam(String param){
        System.out.println("参数："+param);
    }
}
