package com.ytt.shopping.model.vo;

import com.ytt.shopping.model.dto.UserDTO;
import lombok.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:13 2019/4/23
 * @Modiflid By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WorkStatus extends UserDTO {

    private String work;

    private int status;

    private String message;

    @Override
    public String toString() {
        return "WorkStatus{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", age='" + getAge() + '\'' +
                ", work='" + work + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
