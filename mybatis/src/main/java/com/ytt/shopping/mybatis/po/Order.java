package com.ytt.shopping.mybatis.po;

import lombok.*;

import java.util.List;

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
public class Order extends BaseEntity {

    private Long customerId;

    private String customer;

    private OrderState state;

    private List<Goods> goodsList;

}
