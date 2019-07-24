package com.ytt.spring.context.annotation.model;

import lombok.Data;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:09 2019/7/23
 * @Modiflid By:
 */
@Data
public class Bike {

    public Bike() {
        System.out.println("Bike Constructor...");
    }

    public void init(){
        System.out.println("Bike...init...");
    }

    public void destory(){
        System.out.println("Bike...destory...");
    }

}
