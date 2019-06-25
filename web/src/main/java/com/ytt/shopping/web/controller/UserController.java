package com.ytt.shopping.web.controller;

import com.ytt.shopping.model.dto.UserDTO;
import com.ytt.shopping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:17 2019/4/22
 * @Modiflid By:
 */

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public UserDTO addUser(@Valid UserDTO user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
        }

        UserDTO u = userService.save(user);

        return u;
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public UserDTO getUser(UserDTO user){
        UserDTO u = userService.get(user);
        return u;
    }

}
