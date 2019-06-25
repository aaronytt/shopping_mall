package com.ytt.shopping.service;

import com.ytt.shopping.model.dto.UserDTO;

public interface UserService {

    UserDTO save(UserDTO user);

    UserDTO get(UserDTO user);

    UserDTO getById(long id);

    long update(UserDTO user);

    void delete(long id);

}
