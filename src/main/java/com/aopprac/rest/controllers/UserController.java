package com.aopprac.rest.controllers;

import com.aopprac.model.UserDto;
import com.aopprac.rest.entities.User;
import com.aopprac.rest.service.UserServiceRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceRest userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveUser")
    @ResponseBody
    private User saveUserUponSignUp(@RequestBody User user){
        user = modelMapper.map(user, User.class);
        User user1 = this.userService.saveUser(user);
        return user1;
    }

    @GetMapping("/getUserByEmail")
    private UserDto getUserByEmail(@RequestBody UserDto userDto){
        UserDto userDto1 = this.userService.findByEmail(userDto.getEmail());
        return userDto1;
    }
}
