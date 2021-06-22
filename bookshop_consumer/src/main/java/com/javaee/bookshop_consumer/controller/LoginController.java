package com.javaee.bookshop_consumer.controller;

import com.javaee.bookshop_consumer.common.Result;
import com.javaee.bookshop_consumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "loginError")
    public Result<User> login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
        dataMap.add("email", email);
        dataMap.add("password", password);
        //调用springcloud服务提供者的服务
        Result<User> userResult = restTemplate.postForObject("http://user-provider/user/login", dataMap, Result.class);
        HttpSession session = request.getSession();
        session.setAttribute("user", userResult.getData());
        return userResult;
    }

    public Result<User> loginError(@RequestParam String email, @RequestParam String password, HttpServletRequest request){
        return Result.error("522", "发生熔断错误！");
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return Result.success();
    }
}
