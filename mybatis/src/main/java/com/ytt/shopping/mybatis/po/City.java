package com.ytt.shopping.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class City extends BaseEntity implements Serializable {

    private String name;
    private String state;
    private String country;

}
