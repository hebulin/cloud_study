package com.springcloudfeign.service;

import com.springcloudfeign.fallback.MyFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 绑定远程服务的名字springcloud
 *
 * 当Feign和Hystrix fallback一起使用时，如果存在多个同样类型的Bean，
 * 则会引起注解@Autowired不工作，因为没有一个Bean被标示为主（@Primary）的Bean，所以这里需要添加注解@Primary。
 */
@Primary
@FeignClient(name = "springcloud", fallback = MyFallBack.class)
public interface HelloFeign {

    /**
     * 绑定远程服务的请求路径，也就是调用远程的hello方法：requestMapping需要一样
     * @return
     */
    @RequestMapping("/hello")
    public String hello();
}
