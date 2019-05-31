package com.ytt.shopping.api;

import com.ytt.shopping.mybatis.po.User;

public interface UserService {

    User save(User user);

    User get(User user);

    User getById(Long id);

    int update(User user);

    void delete(Long id);

}
