package com.springcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudeurekaApplication8761 {
    // --spring.profiles.active=eureka8761配置该main方法启动时加载applicatio-eureka8761.properties文件。
    // active后的名字为application-后面的名字
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudeurekaApplication8761.class, args);
    }

}
