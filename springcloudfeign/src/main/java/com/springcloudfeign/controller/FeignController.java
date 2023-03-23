package com.springcloudfeign.controller;

import com.springcloudfeign.service.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private HelloFeign helloFeign;

    //已经做好负载均衡了
    @RequestMapping("/web/hello")
    public String hello() {
        //调用声明式服务的方法 实现对远程服务的调用
        String hello = helloFeign.hello();
        System.out.println("调用HelloFeign");
        return hello;
    }
}
