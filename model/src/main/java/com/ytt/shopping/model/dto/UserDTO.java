package com.ytt.shopping.model.dto;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:10 2019/5/31
 * @Modiflid By:
 */
import com.ytt.shopping.model.po.UserPO;
import lombok.*;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@EqualsAndHashCode
public class UserDTO extends UserPO implements Serializable {

    @Min(value = 18, message = "未满18岁禁止入内")
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
}
