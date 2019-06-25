package com.ytt.shopping.web.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:21 2019/6/6
 * @Modiflid By:
 */
@Configuration
@EnableAspectJAutoProxy
public class FooConfig {

    @Bean
    public TestBean testBeanX(){
        return new TestBean("foo");
    }

    @Bean
    public TestBean testBeanY(){
        return new TestBean("foo");
    }

    @Bean
    public FooAspect fooAspect(){
        return new FooAspect();
    }

}
