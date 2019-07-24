package com.ytt.spring.context.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:18 2019/7/23
 * @Modiflid By:
 */
@SpringBootApplication
public class SpringDemoApplication  implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class);

        System.out.println("IOC容器创建完成...");
//
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//
//        for (String name: beanNames) {
//            System.out.println(name);
//        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringDemoApplication.applicationContext == null) {
            SpringDemoApplication.applicationContext = applicationContext;
        }
    }
}
