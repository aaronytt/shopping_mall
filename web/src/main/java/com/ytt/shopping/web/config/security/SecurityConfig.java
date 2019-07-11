package com.ytt.shopping.web.config.security;//package com.ytt.aaron_demo.config.security;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:16 2019/3/8
 * @Modiflid By:
 */
@Configuration
@EnableAdminServer
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminServerProperties adminServerProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String adminContextPath = adminServerProperties.getContextPath();

        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        //允许所有用户访问"/"和"/index.html"
        http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login/**").permitAll()
//                .antMatchers(adminContextPath + "/index.html").permitAll()
//                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                .and()
                .formLogin().loginPage(adminContextPath + "/login/into").successHandler(successHandler).and()    //  登录页
//                .failureUrl("/login-error.html").permitAll()
                .logout().logoutUrl(adminContextPath + "/login/out").logoutSuccessUrl(adminContextPath + "/login/into").and()
                .httpBasic().and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(
                        adminContextPath + "/instances",
                        adminContextPath + "/actuator/**"
                );
    }
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
}
