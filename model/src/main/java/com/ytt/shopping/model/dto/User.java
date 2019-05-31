package com.ytt.shopping.model.dto;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:10 2019/5/31
 * @Modiflid By:
 */
import lombok.*;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {

    private String username;

    private String password;

    @Min(value = 18, message = "未满18岁禁止入内")
    private int age;

}
