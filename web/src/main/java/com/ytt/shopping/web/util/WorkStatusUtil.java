package com.ytt.shopping.web.util;

import com.ytt.shopping.model.dto.UserDTO;
import com.ytt.shopping.model.vo.WorkStatus;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:10 2019/4/23
 * @Modiflid By:
 */
public class WorkStatusUtil {

    public static WorkStatus getWorkStatus(UserDTO user){

        WorkStatusEnum workStatusEnum = Arrays.asList(WorkStatusEnum.values())
                .parallelStream()
                .filter(wse -> wse.getAgeCondition().test(user.getAge()))
                .findFirst()
                .orElse(WorkStatusEnum.NULL);

        WorkStatus workStatus = new WorkStatus();
        BeanUtils.copyProperties(user,workStatus);
        BeanUtils.copyProperties(workStatusEnum,workStatus);

        return workStatus;
    }

}
