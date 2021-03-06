package com.ytt.shopping.mybatis.mapper;

import com.ytt.shopping.model.po.GoodsPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 11:15 2019/6/20
 * @Modiflid By:
 */
@Mapper
public interface GoodsMapper extends BaseMapper<GoodsPO, Long> {

    @Select("SELECT count(0) FROM goods")
    long getCount();

}
