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
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends UserPO implements Serializable {

}
