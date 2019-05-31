package com.ytt.shopping.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:52 2019/4/26
 * @Modiflid By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
