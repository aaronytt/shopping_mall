package com.ytt.shopping.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:14 2019/4/26
 * @Modiflid By:
 */
@Entity
@Table(name = "order")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    private String customer;

    @ManyToMany
    @JoinTable(name = "goods")
    private List<Goods> goodsList;

    @Column(nullable = false)
    private OrderState state;

}
