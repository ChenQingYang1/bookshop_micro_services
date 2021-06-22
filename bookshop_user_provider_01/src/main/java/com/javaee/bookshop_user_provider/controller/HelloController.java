package com.javaee.bookshop_user_provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/service/hello2")
    public String hello() {

        //业务处理

        return "hello,spring cloud.2";
    }
}
