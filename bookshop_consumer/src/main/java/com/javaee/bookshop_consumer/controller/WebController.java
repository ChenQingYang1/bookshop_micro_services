package com.javaee.bookshop_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello1")
    public String hello1() {
        //逻辑判断

        //调用springcloud服务提供者的服务
        return restTemplate.getForEntity("http://book-provider/service/hello1", String.class).getBody();
    }

    @RequestMapping("/web/hello2")
    public String hello2() {
        //逻辑判断

        //调用springcloud服务提供者的服务
        return restTemplate.getForEntity("http://user-provider/service/hello2", String.class).getBody();
    }
}
