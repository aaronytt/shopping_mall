package com.ytt.shopping.eureka.web.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.money.Money;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 10:53 2019/6/20
 * @Modiflid By:
 */
@Getter
@Setter
@ToString
public class GoodsRequest {

    @NotBlank
    private String name;

    @NotNull
    private Money price;

}
