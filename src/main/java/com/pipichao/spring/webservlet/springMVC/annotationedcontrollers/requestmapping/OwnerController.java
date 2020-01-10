package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Pet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我们可以在类和方法中定义 url 路径参数：
 * 路径参数会被转换成合适的类型，或者 TypeMismatchException  异常会被抛出
 * */
@RestController
@RequestMapping(value = "owner/{ownerId}"
//        , produces = "!application/json",//产生的媒体类型 支持 逻辑反操作 如  !text/plain 返回除了 text/plain之外的任何类型
//        consumes = "!application/json"
)//同上
//如果produces 等属性定义在类上 贼该类的所有方法都具有 这样的属性
//当方法级 的属性被定义后 方法的会被所定义的覆盖
public class OwnerController {
    @GetMapping(value = "/pet/{petId}",
            params ={"petId=1001","ownerId"} //必须包含参数 ownerId 并且 petId=1001
            // 这里的参数得用 path？param=value的形式，url参数识别不了
            //会报400  Parameter conditions "petId=1001, ownerId" not met for actual request parameters:
            ,headers = {"Host=localhost:8074","Content-Type=application/json"}//请求头必须包含
            )
    //等同于
//    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public Pet findPet(@PathVariable ("ownerId")String oId,@PathVariable("petId") String pId){
        System.out.println("ownerId:"+oId);
        System.out.println("petId:"+pId);
        return null;
    }
}
