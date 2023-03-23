package com.springcloudconsumer.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("web/hello")
    public String hello() {

        //调用提供者服务RestTemplate,配置这个类
//      ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/hello", String.class);
        //还可以传入参数：数组（http://xxxx/xx?name={0}&id={1}）或者map（http://xxxx/xx?name={name}&id={id}）。
        // post、get、delete、put等方法
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://SPRINGCLOUD/hello", String.class);
        System.out.println("forEntity:" + forEntity.toString());
        String body = forEntity.getBody();

        return body;
    }


    @RequestMapping("web/hystrix")
    //开启熔断功能：负载太多，造成服务器挂起等，需要熔断，降级等操作,
    // fallbackMethod回调error方法(回调方法，就是降级方法)。。。。版本好像有问题
    //还可以设置超时时间，超过时间没有返回就熔断
    //设置ignoreException参数，过滤掉该异常类型，再抛出此异常时就不会进入熔断降级
    //还可以继承hystrixcommand类写自定义降级方法.其中execute是同步调用；queue是异步调用，再通过get方法获取异步返回的结果
    //自定义中调用super的getexecutonexception获取异常信息
    //
//    @HystrixCommand(fallbackMethod = "error")
    public String hystrix() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://SPRINGCLOUD/hello", String.class);
        String body = forEntity.getBody();

        return body;
    }

    public String error() {
        return "error";
    }

    /**
     * 降级方法
     * 调用方法中自己产生异常时 会触发该降级方法，自动传入一个错误信息的参数，可以得到异常信息
     * @param throwable
     * @return
     */
    public String error(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return "error";
    }
}
