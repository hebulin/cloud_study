package com.springcloudconsumer.config;

import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    /**
     * 根据restTemplate名字获取该Bean
     * 相当于xml的
     * <bean id="" class="xxx.xxx.class">
     *
     * </bean>
     * @return
     */
    //使用ribbon实现负载均衡的调用
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //设置其他算法策略配置负载均衡
//    @Bean
//    public AlwaysMatchInstanceStatusRule rule(){
//        return new RandomLoadBalancer();
//    }

}
