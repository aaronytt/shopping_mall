package com.ytt.spring.context.annotation.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:52 2019/7/24
 * @Modiflid By:
 */
@Data
public class Bird implements Serializable {

    public Bird() {
        super();
    }

    @Value("sam")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${color}")
    private String color;
}
