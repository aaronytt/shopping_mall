package com.ytt.shopping.redis.test;

import com.ytt.shopping.core.util.GsonUtil;
import com.ytt.shopping.model.dto.User;
import com.ytt.shopping.redis.RedisApplication;
import com.ytt.shopping.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:43 2019/5/30
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisApplication.class})
@Slf4j
public class RedisTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void testRun(){
        System.out.println("redis run...");
    }

    @Test
    public void testSet(){
        User user = new User();
        user.setUsername("ytt");
        user.setAge(18);
        System.out.println(user.toString());

        redisUtil.set("ytt",GsonUtil.getGson().toJson(user),0);
    }

    @Test
    public void testGet(){
        String userStr = redisUtil.get("ytt",0);
        System.out.println("redis return:  " + userStr);
        User user = GsonUtil.getGson().fromJson(userStr,User.class);
        System.out.println("gson parse:  " + user);
    }

    @Test
    public void testDel(){
        redisUtil.del(0,"ytt");
        String userStr = redisUtil.get("ytt",0);
        System.out.println("redis return:  " + userStr);
        User user = GsonUtil.getGson().fromJson(userStr,User.class);
        System.out.println("gson parse:  " + user);
    }

}
