package com.ytt.shopping.service.test;

import com.ytt.shopping.model.dto.UserDTO;
import com.ytt.shopping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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

        UserDTO firstUser = new UserDTO();

        firstUser.setUsername("aaron");
        firstUser.setPassword("123456");
        firstUser.setAge(18);

        userService.save(firstUser);
        int i=0;

        while (i<5){
            UserDTO user_one = userService.getById(firstUser.getId());
            System.out.println(user_one);
            i++;
        }

        userService.delete(firstUser.getId());

        i=0;
        while (i<5){
            UserDTO user_one = userService.getById(firstUser.getId());
            System.out.println(user_one);
            i++;
        }

    }

}
