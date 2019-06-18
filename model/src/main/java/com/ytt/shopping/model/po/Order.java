package com.ytt.shopping.model.po;

import com.ytt.shopping.model.base.BaseEntity;
import com.ytt.shopping.model.enumeration.OrderState;
import lombok.*;

import java.io.Serializable;
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
@EqualsAndHashCode
public class Order extends BaseEntity implements Serializable {

    private Long customerId;

    private String customer;

    private OrderState state;

    private List<Goods> goodsList;

}
