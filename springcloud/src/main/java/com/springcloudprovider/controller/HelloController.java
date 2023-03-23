package com.springcloudprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        //提供者业务
        System.out.println("===============provider01================");

        return "Hello I am Provider 1";
    }
}
