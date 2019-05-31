package com.ytt.shopping.mybatis.mapper;

import com.ytt.shopping.mybatis.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    Long insert(User user);

    List<User> selectAll();

    User selectOne(User user);

}
