package com.ytt.shopping.rest;

import lombok.*;
import org.joda.money.Money;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:14 2019/4/26
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode()
public class Goods implements Serializable {

    private String name;

    private Money price;

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
