package com.ytt.shopping.server;

import com.ytt.shopping.api.UserService;
import com.ytt.shopping.mybatis.mapper.UserMapper;
import com.ytt.shopping.mybatis.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 13:42 2019/5/31
 * @Modiflid By:
 */
@Service
public class UserServer implements UserService {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'user'";
    private static final String CACHE_NAME = "users";

    @Autowired
    private UserMapper userMapper;

    @Override
    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY)
    public User save(User user) {
        Long id = userMapper.insert(user);
        user.setId(id);
        return user;
    }

    @Cacheable(value = CACHE_NAME,key = CACHE_KEY + " + #user.getId()")
    @Override
    public User get(User user) {
        User u = userMapper.selectOne(user);
        return u ;
    }

    @Cacheable(value = CACHE_NAME,key = CACHE_KEY + " + #id")
    @Override
    public User getById(Long id) {
        System.out.println("没有走缓存");
        User user = new User();
        user.setId(id);
        User u = userMapper.selectOne(user);
        return u ;
    }

    @CachePut(value = CACHE_NAME,key = CACHE_KEY + " + #user.getId()")
    @Override
    public int update(User user) {
        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");
        /**
         * 待续
         */
        return  0;
    }

    //删除用户数据
    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY + " +#id")//这是清除缓存
    @Override
    public void delete(Long id){
        System.out.println("清除缓存");
        return;
    }

}
