package com.ytt.shopping.service;

import com.ytt.shopping.model.dto.UserDTO;

public interface LoginService {

    UserDTO login(String username, String password);

}
