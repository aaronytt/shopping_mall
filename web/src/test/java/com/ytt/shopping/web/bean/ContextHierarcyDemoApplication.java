package com.ytt.shopping.web.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:24 2019/6/6
 * @Modiflid By:
 */
@SpringBootApplication
@Slf4j
public class ContextHierarcyDemoApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(ContextHierarcyDemoApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ApplicationContext fooContext = new AnnotationConfigApplicationContext(FooConfig.class);

        ClassPathXmlApplicationContext barContext = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}, fooContext);

        TestBean bean = fooContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        log.info("=============");

        bean = barContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        bean = barContext.getBean("testBeanY", TestBean.class);
        bean.hello();
    }
}
