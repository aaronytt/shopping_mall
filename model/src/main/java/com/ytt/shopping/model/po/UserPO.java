package com.ytt.shopping.model.po;

import com.ytt.shopping.model.base.BaseEntity;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserPO extends BaseEntity implements Serializable {

    private String username;

    private String password;

    private int age;

}
