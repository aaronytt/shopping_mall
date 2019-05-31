package com.ytt.shopping.server.test;

import com.ytt.shopping.api.UserService;
import com.ytt.shopping.mybatis.po.User;
import com.ytt.shopping.server.ServerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 13:35 2019/5/31
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Slf4j
public class CacheTest {

    @Autowired
    UserService userService;

    @Test
    public void RedisCacheTest(){

        User firstUser = new User();

        firstUser.setUsername("aaron");
        firstUser.setPassword("123456");
        firstUser.setAge(18);

        userService.save(firstUser);
        int i=0;

        while (i<5){
            User user_one = userService.getById(firstUser.getId());
            System.out.println(user_one);
            i++;
        }

        userService.delete(firstUser.getId());

        i=0;
        while (i<5){
            User user_one = userService.getById(firstUser.getId());
            System.out.println(user_one);
            i++;
        }

    }

}
