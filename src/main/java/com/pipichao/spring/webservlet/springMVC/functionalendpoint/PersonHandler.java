package com.pipichao.spring.webservlet.springMVC.functionalendpoint;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Person;
import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@Data
public class PersonHandler {
    public ServerResponse test(ServerRequest request){
        try {
            //将请求格式化成String
            String body=request.body(String.class);
            //从body中取出 person list
            List<Person> list=request.body(new ParameterizedTypeReference<List<Person>>() {
            });
            //获取参数
            MultiValueMap<String,String> params=request.params();
            return ok().contentType(MediaType.APPLICATION_JSON).body(new Person());
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();
        }

//        The following example shows how to build a 201 (CREATED) response with a Location header and no body:
        //如何创建一个201响应，带有一个位置，没有请求体
        URI uri = null;
        try {
            uri = new URI("http://www.baidu.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ServerResponse.created(uri).build();
    }
    public ServerResponse listPeople(ServerRequest request) {
        // ...
        List<Person> list=new ArrayList<>();
        return ok().contentType(MediaType.APPLICATION_JSON).body(list);

    }

    public ServerResponse createPerson(ServerRequest request) {
        // ...
        try {
            Person person=request.body(Person.class);
            //保存到数据库
            //savePerson()
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok().build();
    }

    public ServerResponse getPerson(ServerRequest request) {
        // ...
        String personId=request.pathVariable("personId");
        System.out.println(personId);
        Person person=new Person();//根据id查出数据
        return ok().contentType(MediaType.APPLICATION_JSON).body(person);
    }
    /**
     * 还可以利用 lamda 表达式 定义处理器
     * */
    HandlerFunction<ServerResponse> getPersonById=request -> {
        String personId=request.body(String.class);
        System.out.println(personId);
        return ok().contentType(MediaType.APPLICATION_JSON).body("hello");
    };
}
