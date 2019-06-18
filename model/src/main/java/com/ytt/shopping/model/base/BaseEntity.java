package com.ytt.shopping.model.base;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:52 2019/4/26
 * @Modiflid By:
 */
@Getter
@Setter
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    
}
