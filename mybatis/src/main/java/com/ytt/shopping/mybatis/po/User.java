package com.ytt.shopping.mybatis.po;

import lombok.*;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {

    private String username;

    private String password;

    private int age;

}
