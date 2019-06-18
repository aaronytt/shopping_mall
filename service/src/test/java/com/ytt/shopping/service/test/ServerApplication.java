package com.ytt.shopping.service.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:41 2019/5/30
 * @Modiflid By:
 */
@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
@MapperScan("com.ytt.shopping.mybatis.mapper")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }

}
