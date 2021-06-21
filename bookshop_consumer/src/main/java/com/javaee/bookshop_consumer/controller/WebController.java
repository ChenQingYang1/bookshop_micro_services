package com.javaee.bookshop_consumer.controller;

import com.javaee.bookshop_consumer.common.Result;
import com.javaee.bookshop_consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

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

//    @PostMapping("/user/login")
//    public Result<User> login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
//        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
//        dataMap.add("email", email);
//        dataMap.add("password", password);
//        //调用springcloud服务提供者的服务
//        return restTemplate.postForObject("http://user-provider/user/login", dataMap, Result.class);
//    }
}
