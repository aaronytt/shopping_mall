package com.ytt.shopping.web.aspect;

import com.ytt.shopping.core.util.StringUtil;
import com.ytt.shopping.model.dto.UserDTO;
import com.ytt.shopping.web.util.WorkStatusUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:48 2019/4/22
 * @Modiflid By:
 */
@Aspect
@Component
@Slf4j
public class UserHttpAspect {

    @Pointcut("execution(public * com.ytt.shopping.web.controller.UserController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void paramLog(JoinPoint joinPoint) throws Throwable{
        RequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
        //url
        String url = request.getRequestURL().toString();
        //method
        String method = request.getMethod();
        //ip
        String ip = request.getRemoteAddr();
        //类方法
        String class_method = StringUtil.combine(joinPoint.getSignature().getDeclaringTypeName(),
                ".",
                joinPoint.getSignature());
        //参数
        Object[] args = joinPoint.getArgs();

        log.info("[ url= {}, menthod= {}, ip= {}, class_method= {}, args= {} ]",url,method,ip,class_method,args);
    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void resultLog(JoinPoint joinPoint, Object ret) throws Throwable{
        log.info("[ return: {} ]",ret);
    }

    @Around("execution( public * com.ytt.shopping.web.controller.UserController.getUser(..))")
    public Object result(ProceedingJoinPoint joinPoint) throws Throwable{

        Object ret = joinPoint.proceed();

        if(Optional.ofNullable(ret).isPresent()){
            ret = WorkStatusUtil.getWorkStatus((UserDTO)ret);
        }

        log.info("[ return: {} ]",ret);

        return ret;
    }

}
