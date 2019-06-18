package com.ytt.shopping.model.po;

import com.ytt.shopping.model.base.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:37 2019/3/8
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CityPO extends BaseEntity implements Serializable {

    private String name;

    private String state;

    private String country;

}
