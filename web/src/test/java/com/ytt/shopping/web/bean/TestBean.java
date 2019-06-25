package com.ytt.shopping.web.bean;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;

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

    public static void main(String[] args) {
        System.out.println(NumberUtils.createBigDecimal("10.0101"));
        System.out.println(Money.of(CurrencyUnit.of("CNY"),
                NumberUtils.createBigDecimal("10.0101")));
    }
}
