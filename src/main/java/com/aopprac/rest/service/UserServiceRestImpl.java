package com.aopprac.rest.service;

import com.aopprac.model.UserDto;
import com.aopprac.rest.entities.User;
import com.aopprac.rest.repositories.UserRepository;
import com.aopprac.rest.service.UserServiceRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceRestImpl implements UserServiceRest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User saveUser(User user) {
        User user1 = this.userRepository.save(user);
        return user1;
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
