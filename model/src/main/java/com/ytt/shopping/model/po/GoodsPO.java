package com.ytt.shopping.model.po;

import com.ytt.shopping.model.base.BaseEntity;
import lombok.*;
import org.joda.money.Money;

import java.io.Serializable;

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
@EqualsAndHashCode(callSuper = true)
public class GoodsPO extends BaseEntity<Long> implements Serializable {

    private String name;

    private Money price;

}
