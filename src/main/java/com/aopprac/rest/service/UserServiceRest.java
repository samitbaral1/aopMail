package com.aopprac.rest.service;

import com.aopprac.model.UserDto;
import com.aopprac.rest.entities.User;

public interface UserServiceRest {
    User saveUser(User user);
    UserDto findByEmail(String userName);
}
