package com.pipichao.spring.webservlet.springMVC.functionalendpoint;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

/**
 * 注册控制器
 * */
@Configuration
public class PersonRouter {

    PersonHandler handler=new PersonHandler();

    RouterFunction<ServerResponse> router=route()
            .GET("/person/{personId}",handler::getPerson)
            .GET("/listPerson",accept(MediaType.APPLICATION_JSON),handler::listPeople)
            .GET("createPerson",handler::createPerson).build();
//            .GET("/getPersonById",handler::getGetPersonById)
}
