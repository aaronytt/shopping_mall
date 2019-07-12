package com.ytt.shopping.service.impl;

import com.ytt.shopping.core.util.StringUtil;
import com.ytt.shopping.model.dto.UserDTO;
import com.ytt.shopping.service.LoginService;
import com.ytt.shopping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO login(String username, String password){
        UserDTO u = new UserDTO();
        u.setUsername(username);
        u.setPassword(password);
        UserDTO user = userService.get(u);
        if(user != null){
            log.info(StringUtil.combine(">>>> * ", username ," * >>>>pass ytt"));
        }else {
            log.info(StringUtil.combine(">>>> * ", username ," * >>>>password error"));
        }
        return user;
    }

}
