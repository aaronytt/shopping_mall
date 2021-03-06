package com.ytt.shopping.model.dto;

import com.ytt.shopping.model.po.CityPO;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:28 2019/6/19
 * @Modiflid By:
 */
@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CityDTO extends CityPO implements Serializable {

}
