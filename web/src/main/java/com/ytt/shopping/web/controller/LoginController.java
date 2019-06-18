package com.ytt.shopping.web.controller;

import com.ytt.shopping.core.util.StringUtil;
import com.ytt.shopping.model.dto.UserDTO;
import com.ytt.shopping.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {


    private final static Logger LOG= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @GetMapping("/to")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        LOG.info(StringUtil.combine("在", remoteAddr, "访问登陆主页"));
        return "/views/login";
    }

    @ResponseBody
    @PostMapping(value = "/into")
    public UserDTO loginInto(@RequestParam("userid") String username,
                             @RequestParam("psw") String password){
        UserDTO user = loginService.login(username,password);

        return user;
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String[] login(String username, String password){
//        loginService.login(username,password);
//        ((UserService)loginService).updateUesr();
//        return new String[]{"welcome","come"};
//    }

}
