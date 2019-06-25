//package com.ytt.shopping.server;
//
//import com.ytt.shopping.api.UserService;
//import com.ytt.shopping.model.dto.UserDTO;
//import com.ytt.shopping.model.po.UserPO;
//import com.ytt.shopping.mybatis.mapper.UserMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 13:42 2019/5/31
// * @Modiflid By:
// */
//@Service
//@Slf4j
//public class UserServer implements UserService {
//
//    //这里的单引号不能少，否则会报错，被识别是一个对象
//    private static final String CACHE_KEY = "'user'";
//    private static final String CACHE_NAME = "users";
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY)
//    public UserDTO save(UserDTO user) {
//        Long id = userMapper.insert(user);
//        user.setId(id);
//        return user;
//    }
//
//    @Cacheable(value = CACHE_NAME,key = CACHE_KEY + " + #user.toString()")
//    @Override
//    public UserDTO get(UserDTO user) {
//        UserPO userPO = userMapper.selectOne(user);
//        UserDTO userDTO = new UserDTO();
//        BeanUtils.copyProperties(userPO,userDTO);
//        return userDTO ;
//    }
//
//    @Cacheable(value = CACHE_NAME,key = CACHE_KEY + " + #id")
//    @Override
//    public UserDTO getById(Long id) {
//        System.out.println("没有走缓存");
//        UserDTO user = new UserDTO();
//        user.setId(id);
//        UserPO userPO = userMapper.selectOne(user);
//        UserDTO userDTO = new UserDTO();
//        BeanUtils.copyProperties(userPO,userDTO);
//        return userDTO ;
//    }
//
//    @CachePut(value = CACHE_NAME,key = CACHE_KEY + " + #user.getId()")
//    @Override
//    public int update(UserDTO user) {
//        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");
//        /**
//         * 待续
//         */
//        return  0;
//    }
//
//    //删除用户数据
//    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY + " +#id")//这是清除缓存
//    @Override
//    public void delete(Long id){
//        System.out.println("清除缓存");
//        return;
//    }
//
//}
