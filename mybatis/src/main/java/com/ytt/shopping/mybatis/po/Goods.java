package com.ytt.shopping.mybatis.po;

import lombok.*;
import org.joda.money.Money;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:14 2019/4/26
 * @Modiflid By:
 */
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Goods extends BaseEntity {

    private String name;

    private Money price;

}
