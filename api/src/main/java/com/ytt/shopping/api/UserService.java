package com.ytt.shopping.api;

import com.ytt.shopping.model.dto.UserDTO;

public interface UserService {

    UserDTO save(UserDTO user);

    UserDTO get(UserDTO user);

    UserDTO getById(Long id);

    int update(UserDTO user);

    void delete(Long id);

}
