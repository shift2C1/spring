package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.handlermethods;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestAtrrController {
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/storeReqAttr")
//    http://localhost:8074/app/storeReqAttr?petId=1001&petName=dog
    public String storeReqAttr( Pet pet){
        request.setAttribute("petReq",pet);
        System.out.println("storeReqAttr");
//        return "forward:getReqAtt";//转发可以获取
        return "redirect:getReqAtt";//直接400 ：Missing request attribute 'petReq' of type Pet
    }
    @GetMapping("/getReqAtt")
    @ResponseBody
    public String getReqAtt(@RequestAttribute("petReq")Pet pet){
        System.out.println("getReqAtt"+pet);
        return "hahha";
    }
}
