package com.javaee.bookshop_user_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启客户端功能
public class BookshopUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshopUserProviderApplication.class, args);
    }

}
