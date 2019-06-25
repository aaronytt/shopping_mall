package com.ytt.shopping.model.dto;

import com.ytt.shopping.model.po.GoodsPO;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 11:02 2019/6/20
 * @Modiflid By:
 */
@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GoodsDTO extends GoodsPO implements Serializable {

}
