package com.springcloudfeign.fallback;

import com.springcloudfeign.service.HelloFeign;
import org.springframework.stereotype.Component;

@Component
public class MyFallBack implements HelloFeign {

    /**
     * HelloFeign的hello方法调不通、异常时调用这个方法
     *
     * @return
     */
    @Override
    public String hello() {
        System.out.println("调用MyFallBack");
        return "MyFallBack error";
    }
}
