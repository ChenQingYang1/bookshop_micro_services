package com.javaee.bookshop_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//开启Eureka注册中心服务端
public class BookshopEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshopEurekaServerApplication.class, args);
    }

}
