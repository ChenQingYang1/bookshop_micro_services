package com.javaee.bookshop_consumer.controller;

import com.javaee.bookshop_consumer.common.Result;
import com.javaee.bookshop_consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Result createSingleUser(@RequestBody User newUser) {
        Result userResult = restTemplate.postForObject("http://user-provider/register", newUser, Result.class);
        return userResult;
    }
}
