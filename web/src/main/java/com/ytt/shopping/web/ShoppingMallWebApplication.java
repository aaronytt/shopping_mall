package com.ytt.shopping.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
@MapperScan("com.ytt.shopping.mybatis.mapper")
@ComponentScan("com.ytt.shopping")
public class ShoppingMallWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallWebApplication.class, args);
    }

}
