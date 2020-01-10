package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.handlermethods;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

//@RestController
@RestController
/**
 * @SessionAttributes:
 * 它被用作 在不同请求之间的同一个session中存储 model attributes
 * 是一个类级别的注解，它申明了特定的controller中使用的 session attributes
 *
 * 当第一个请求到来的时候，一个叫做 petSession 的model attribute 会被存储到 http servlet session中
 * 它会一直存在，直到其他controller 中的方法 调用了 SessionStatus  的方法来清除存储
 * */
@SessionAttributes(value = {"petSession"})
//该类的方法都需要 petSession 否则 Expected session attribute 'petSession'
//存储session 应在 另一个controller 中
public class SessionAtrributeController {

    /**
     * 测试 @SessionAttributes
     *
     * */
//    @GetMapping("/storeSessionAtt")
//    public String storeSessionAtt(@ModelAttribute("petSession") Pet petSession){ //
//        System.out.println("添加到session中。。。");
//        System.out.println(petSession);
//        return "add success";
//    }

    @GetMapping("/getSessionAttr")
    public String getSessionAttr(@ModelAttribute("petSession") Pet pet, BindingResult result){
        System.out.println("获取session的数据：");
        System.out.println(result);
        System.out.println(pet);
        return  "获取成功";
    }
    @GetMapping("/getSessionAttrAndClear")
    /**
     * 存储在session中的petSession 可以通过@ModelAttribute 获得
     * */
    public String getSessionAttrAndClear(@ModelAttribute("petSession")Pet pet,BindingResult result, SessionStatus sessionStatus){
        System.out.println(result);
        System.out.println(pet);
//        System.out.println("没有清除");

        //清空petSession
        sessionStatus.setComplete();
        System.out.println("先获取，后清除了petSession");
        return  "清除成功";
    }

    @GetMapping("getSession")
    public String getSession(@SessionAttribute("petSession")Pet pet){
        System.out.println("通过@SessionAttribute获取session的值");
        System.out.println(pet);
        return "通过@SessionAttribute获取成功";
    }
}
