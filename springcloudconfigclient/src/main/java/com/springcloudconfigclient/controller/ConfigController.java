package com.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    //远程git的url的值
    @Value("${url}")
    private String url;

    @RequestMapping("/cloud/url")
    public String url(){

        return url;
    }
}
