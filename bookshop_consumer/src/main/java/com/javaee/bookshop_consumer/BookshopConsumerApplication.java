package com.javaee.bookshop_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启熔断功能
public class BookshopConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshopConsumerApplication.class, args);
    }

}
