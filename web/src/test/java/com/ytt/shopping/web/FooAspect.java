package com.ytt.shopping.web;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:18 2019/6/6
 * @Modiflid By:
 */
@Aspect
@Slf4j
public class FooAspect {

    @AfterReturning("bean(testBean*)")
    public void printAfter() {
        log.info("after hello()");
    }

}
