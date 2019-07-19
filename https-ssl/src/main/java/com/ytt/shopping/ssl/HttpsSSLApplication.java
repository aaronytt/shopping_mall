package com.ytt.shopping.ssl;

import com.ytt.shopping.ssl.config.PerformanceInteceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
@MapperScan("com.ytt.shopping.mybatis.mapper")
@ComponentScan("com.ytt.shopping")
public class HttpsSSLApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HttpsSSLApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PerformanceInteceptor())
                .addPathPatterns("/goods/**");
    }

}
