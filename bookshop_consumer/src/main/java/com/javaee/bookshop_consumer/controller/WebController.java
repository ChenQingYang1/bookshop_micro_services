package com.javaee.bookshop_consumer.controller;

import com.javaee.bookshop_consumer.entity.User;
import com.javaee.bookshop_consumer.kafka.KafkaProducer;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/kafka/", produces = APPLICATION_JSON_UTF8_VALUE)
public class WebController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/message")
    public User sendKafkaMsg(@RequestBody User user){
        kafkaProducer.sendKafkaMessage(user);
        return user;
    }

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
