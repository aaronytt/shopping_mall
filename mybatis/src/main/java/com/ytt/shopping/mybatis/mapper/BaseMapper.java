package com.ytt.shopping.mybatis.mapper;

import java.io.Serializable;

public interface BaseMapper<T,ID extends Serializable> {

    int insert(T record);

    int insertSelective(T record);

    int deleteByPrimaryKey(ID id);

    T selectByPrimaryKey(ID id);

    T selectSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

}
