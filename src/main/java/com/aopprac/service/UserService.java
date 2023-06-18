package com.aopprac.service;

import com.aopprac.model.UserDto;


public interface UserService {
    UserDto saveUser(UserDto user);
    UserDto getUserByEmail(String email);
}
