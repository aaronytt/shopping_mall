package com.ytt.shopping.service.impl;

import com.ytt.shopping.model.dto.GoodsDTO;
import com.ytt.shopping.model.po.GoodsPO;
import com.ytt.shopping.mybatis.mapper.GoodsMapper;
import com.ytt.shopping.service.GoodsService;
import org.joda.money.Money;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 11:09 2019/6/20
 * @Modiflid By:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public GoodsDTO saveGoods(String name, Money price) {
        GoodsPO goodsPO = GoodsPO.builder().name(name).price(price).build();
        long id = goodsMapper.insert(goodsPO);
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goodsPO,goodsDTO);
        return goodsDTO;
    }

    @Override
    public GoodsDTO getById(long id) {
        GoodsPO goodsPO = goodsMapper.selectByPrimaryKey(id);
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goodsPO,goodsDTO);
        return goodsDTO;
    }

    @Override
    public List<GoodsDTO> getList(GoodsDTO goods) {
        return goodsMapper.selectSelective(goods)
                .stream()
                .map(goodsPO -> {
                    GoodsDTO goodsDTO = new GoodsDTO();
                    BeanUtils.copyProperties(goodsPO,goodsDTO);
                    return goodsDTO;
                })
                .collect(Collectors.toList());
    }

}