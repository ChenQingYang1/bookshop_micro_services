package com.javaee.bookshop_user_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient//开启客户端功能
public class BookshopUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshopUserProviderApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder encoding() {
        return new BCryptPasswordEncoder();
    }
}
