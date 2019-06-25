package com.ytt.shopping.service;

import com.ytt.shopping.model.dto.GoodsDTO;
import org.joda.money.Money;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 11:09 2019/6/20
 * @Modiflid By:
 */
public interface GoodsService {
    GoodsDTO saveGoods(String name, Money price);

    GoodsDTO getById(long id);

    List<GoodsDTO> getList(GoodsDTO goods);
}
