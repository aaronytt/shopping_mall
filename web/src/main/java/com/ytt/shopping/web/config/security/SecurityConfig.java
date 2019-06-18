package com.ytt.shopping.web.config.security;//package com.ytt.aaron_demo.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 21:16 2019/3/8
// * @Modiflid By:
// */
//@Configuration
//@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //  允许所有用户访问"/"和"/index.html"
////        http.authorizeRequests()
////                .antMatchers("/", "/index.html").permitAll()
////                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
////                .and()
////                .formLogin()
////                .loginPage("/login.html")   //  登录页
////                .failureUrl("/login-error.html").permitAll()
////                .and()
////                .logout()
////                .logoutSuccessUrl("/index.html");
//        http.authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////               auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////                return new BCryptPasswordEncoder();
////    }
//
//}
