package com.ytt.spring.transaction.service;

import com.ytt.shopping.model.po.UserPO;
import com.ytt.shopping.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:32 2019/7/26
 * @Modiflid By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public long createUser() {
        long r = userMapper.insert(UserPO.builder().username("xiaoyu").age(10).password("123456").build());
        return 1/0 == 0 ? r : -1;
    }

}
