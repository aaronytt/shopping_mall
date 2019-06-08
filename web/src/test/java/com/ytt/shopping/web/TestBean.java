package com.ytt.shopping.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:16 2019/6/6
 * @Modiflid By:
 */
@AllArgsConstructor
@Slf4j
public class TestBean {
    private String context;

    public void hello(){
        log.info("hello " + context);
    }

}
