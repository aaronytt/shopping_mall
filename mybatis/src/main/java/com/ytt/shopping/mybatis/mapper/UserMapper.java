package com.ytt.shopping.mybatis.mapper;

import com.ytt.shopping.model.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    Long insert(UserPO user);

    List<UserPO> selectAll();

    UserPO selectOne(UserPO user);

}
