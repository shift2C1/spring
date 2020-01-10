package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.handlermethods;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Arrays;


/**
 * 接收和返回的参数绑定
 * */
@RestController("PersonController1")
public class PersonController {
    /**
     *
     * Missing matrix variable 'q' for method parameter of type int   ??????
     * */

    @GetMapping("/myMethod/{petId}")
    public void myMethod(@PathVariable("petId")String petid, @MatrixVariable(value = "color")String nameArray){
        System.out.println(nameArray);
//        Arrays.stream(nameArray).forEach(name->System.out.println(name));
    }

    // /pets/42;q=11;r=22 缺少矩阵参数？
    @GetMapping("/pets/{petId}")
    public void findPet(@PathVariable String petId, @MatrixVariable int q) {
        System.out.println(petId);
        System.out.println(q);
        // petId == 42
        // q == 11
    }

    /**
     * http://localhost:8074/app/getParams?petId=1001&petName=dog
     * 只能接受单个参数 对象不能被接受
     * 以上若要接受 ：@RequestParam("petId") @RequestParam("petName")
     * */
    @GetMapping("getParams")
    public void getParams(@RequestParam()Pet pet){
        System.out.println(pet);
    }

    /**
     * 获取请求头的参数
     * */
    @GetMapping("/getHeaders")
    public void getHeaders(@RequestHeader("contentType")String contentType,
                           @RequestHeader("Host")String host){
        System.out.println(contentType);
        System.out.println(host);

    }
    /**
     * 获取cookie的值
     * 在postman中添加cookie ：username=zhangsan
     *
     * JSESSIONID 拿不到？？
     * */
    @GetMapping("getCookies")
    public void getCookies(@CookieValue("username")String cookie1){
        System.out.println(cookie1);
    }

    /**
     * http://localhost:8074/app/getModelAttribute?petId=1001&petName=dog 可以绑定到参数
     * */
//    @GetMapping("getModelAttribute")
    /**
     *http://localhost:8074/app/getModelAttribute/1001/subpath/dog
     * restful 的传参风格 两个参数不可以连一起 ：{petId}/{petName} 这样的型式错误
     * */
    @GetMapping("/getModelAttribute/{petId}/subpath/{petName}")
    public void getModelAttribute(@ModelAttribute("pet")Pet pet, BindingResult result){// ModelAttribute 可以用来接受get请求来打包对象
        //绑定结果
//
        System.out.println(result.toString());
        System.out.println(pet.toString());//Pet(petId=1001, petName=dog)
    }

//    @Autowired
//    private HttpSession session;
    @GetMapping("/storeSessionAtt")
    //http://localhost:8074/app/storeSessionAtt?petId=1001&petName=dog
    public String storeSessionAtt(@ModelAttribute("petSession") Pet pet){ //
        System.out.println("另一个方法中");
//        Model model=new ConcurrentModel();
//        model.addAttribute("petSession",pet);//没添加进去
//        session.setAttribute("petSession",pet);//添加进去了
        System.out.println(pet);
        return  "add success";
    }
/**
 * 问题1：
 * 只要添加到了session 里就可以获取到 通过@ModelAttribute @SessionAttribute 都可以
 * 但是通过@ModelAttribute 添加不到session 里
 * 通过 httpsession 可以添加进去
 *问题2：
 * 如果session 里 和 model 里 同时存在 同名的 attribute
 * 通过@ModelAttribute 获取参数会获取那个域里的？
 * 猜想：会获取 Model 里的 （代表request 域），会自动缩小范围
 *
 * */
    //    @SessionAttribute
//    @RequestAttribute

}
