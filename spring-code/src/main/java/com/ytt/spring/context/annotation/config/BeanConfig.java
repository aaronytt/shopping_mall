package com.ytt.spring.context.annotation.config;

import com.ytt.spring.context.annotation.model.Bike;
import com.ytt.spring.context.annotation.model.Bird;
import com.ytt.spring.context.annotation.model.Jeep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:12 2019/7/23
 * @Modiflid By:
 */
@Configuration
public class BeanConfig {

//    @Bean(initMethod = "init", destroyMethod = "destory")
//    public Bike bike(){
//        return new Bike();
//    }
//
//    @Bean(initMethod = "init", destroyMethod = "beanDestory")
//    public Jeep jeep(){
//        return new Jeep();
//    }

    @Bean
    public Bird bird(){
        return new Bird();
    }


//    @Primary//首选项
    @Bean
    public Bird bird2(){
        return new Bird();
    }

}
