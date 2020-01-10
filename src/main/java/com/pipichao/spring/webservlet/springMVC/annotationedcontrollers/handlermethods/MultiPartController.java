package com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.handlermethods;

import com.pipichao.spring.webservlet.springMVC.annotationedcontrollers.requestmapping.entity.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.*;

@Controller
public class MultiPartController {
    /**
     *After a MultipartResolver has been enabled,
     * the content of POST requests with multipart/form-data is parsed and accessible
     * as regular request parameters.
     *
     * 1、设置多媒体解析器后
     * 2、必须post请求
     * 3、contentType : multipart/form-data
     * 4、指定参数名字和注解绑定
     * */
    @ResponseBody
    @PostMapping("/handleFormUpload")
    public String handleFormUpload(@RequestParam("name")String name, @RequestParam("file")MultipartFile myFile){
        System.out.println("name:"+name);
        System.out.println("file"+myFile.getName());
        return "upload success";
    }

    /*
    * 接收多个 参数名字一样的 文件
    * from参数：
    * name：zhangsan
    * file:1.png
    * file:xiangmu.txt
    *

    * */
    @ResponseBody
    @PostMapping("/handleFormUpload1")
    public String handleFormUpload1(@RequestParam("name")String name, @RequestParam("file") List<MultipartFile> myFile){
        System.out.println("name:"+name);
        myFile.stream().forEach(multipartFile -> {
            System.out.println(multipartFile.getOriginalFilename());
        });
        /*
        * 输出
        * name:zhangsan
            1.PNG
            xiangmu.txt
        * */
        return "upload success";
    }

    /**
     * 使用map接收 不用再注解上绑定参数名字
     * map的键是前端参数名，值是上传的文件
     *
     * 这里from参数：
     * name：zhangsan
     * pic:1.png
     * myfile:xiangmu.txt
     * */
    @ResponseBody
    @PostMapping("handleFormUpload2")
    public String handleFormUpload2(@RequestParam("name")String name ,@RequestParam Map<String,MultipartFile> map){
        System.out.println("name："+name);
        new ArrayList<String>(map.keySet()).stream().forEach(key->{
            System.out.println(map.get(key).getName());//参数名字
            System.out.println(map.get(key).getOriginalFilename());//文件名字
        });
        /*
        * 输出
        * name：zhangsan
            pic
            1.PNG
            myfile
            xiangmu.txt
        * */
        return "upload success";
    }

    /**
     * 除了用普通map 还可以使用spring 自带的map
     * */
    @ResponseBody
    @PostMapping("handleFormUpload3")
    public String handleFormUpload3(@RequestParam("name")String name ,@RequestParam MultiValueMap<String,MultipartFile> map){
        System.out.println("name："+name);
        new ArrayList<>(map.keySet()).stream().forEach(key->{
            /*
            * spring自带的map的值只是规定了接收参数的类型
            * 通过键获取的是一个该类型的集合
            * */
            map.get(key).stream().forEach(listIndex->{
                System.out.println(listIndex.getName());
                System.out.println(listIndex.getOriginalFilename());
            });
        });
        /*
        * 输出
        * name：zhangsan
            pic
            1.PNG
            myfile
            xiangmu.txt
        * */
        return "upload success";
    }

    /**
     * 通过打包模型类
     *
     * public class FormItem{
     *      String name;
     *      MultipartFile file
     *
     *      //getters
     *      //setters
     * }
     * ///////同样传表单数据
     * public String upload(FormItem item){
     *     item.getName().sout......
     *     item.getMultipartFile().getName().....
     *     //一系列操作
     * }
     *
     * */


    //////////////////多媒体类型的请求支持非浏览器提交的 restful 服务
    ///////////////////下面的例子展示了 文件和json 混合

    /**
     *POST /someUrl
     * Content-Type: multipart/mixed  //////媒体类型：注意
     *
     * --edt7Tfrdusa7r3lNQc79vXuhIIMlatb7PQg7Vp
     * Content-Disposition: form-data; name="meta-data" ////和注解参数绑定
     * Content-Type: application/json; charset=UTF-8
     * Content-Transfer-Encoding: 8bit
     *
     * {
     *     "name": "value"
     * }
     * --edt7Tfrdusa7r3lNQc79vXuhIIMlatb7PQg7Vp
     * Content-Disposition: form-data; name="file-data"; filename="file.properties"
     * Content-Type: text/xml
     * Content-Transfer-Encoding: 8bit
     * ... File Data ...
     * */

    /*
    * 另一个服务如何请求该方法？？？？？
    * */
    @PostMapping("/multipartMix")
    @ResponseBody
    public String handle(@RequestPart("meta-data") Pet metadata,
                         @RequestPart("file-data") MultipartFile file) {
        // ...
        System.out.println(metadata);
        System.out.println(file.getOriginalFilename());
        return "success";
    }

    /**
     * 实现文件上传 开启多媒体解析，在spring中添加多媒体解析器
     *
     * 需要导入 commons-io、commons-fileupload jar包
     *
     * */
    @Bean
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();//或者其他实现子类
    }
}
