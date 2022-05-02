package com.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author monkjavaer
 * @date 2021/10/29
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        System.out.println("ribbon 服务调用 service-hi 服务");
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

}
