package com.ytt.spring.transaction;

import com.ytt.spring.transaction.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:18 2019/7/23
 * @Modiflid By:
 */
@SpringBootApplication
@MapperScan("com.ytt.shopping.mybatis.mapper")
@ComponentScan("com.ytt.shopping")
public class SpringTransactionDemoApplication implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext applicationContext;

    @Autowired
    static UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionDemoApplication.class);

        System.out.println("IOC容器创建完成...");

        long r = userService.createUser();
        System.out.println(r);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringTransactionDemoApplication.applicationContext == null) {
            SpringTransactionDemoApplication.applicationContext = applicationContext;
        }
    }

}
