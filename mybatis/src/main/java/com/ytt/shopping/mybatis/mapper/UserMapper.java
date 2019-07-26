package com.ytt.shopping.mybatis.mapper;

import com.ytt.shopping.model.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPO, Long>{

}
