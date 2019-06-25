package com.ytt.shopping.model.po;

import com.ytt.shopping.model.base.BaseEntity;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserPO extends BaseEntity<Long> implements Serializable {

    private String username;

    private String password;

    private int age;

}
