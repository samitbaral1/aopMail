package com.aopprac.controller;

import com.aopprac.model.UserDto;
import com.aopprac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Value("${wsHost}")
    private String wsHost;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String homePage(Model model) {
        model.addAttribute("title", "HomePage");
        return "en/index";
    }

    @GetMapping("/signUp")
    private String userSignUp(Model model) {
        model.addAttribute("title", "Sign Up");
        return "en/userSignUp";
    }

    @PostMapping("/signUp")
    private String processRegister(@ModelAttribute UserDto user, Model model) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
        userService.saveUser(user);
        model.addAttribute("loginMessage", "User registered Successfully. Please login to Continue");
        return "en/userlogin";

    }

    @GetMapping("/signIn")
    private String userLogin(Model model) {
        model.addAttribute("title", "Login");
        return "en/userlogin";
    }

    @PostMapping("/welcome")
    private String welcomeUser(@ModelAttribute UserDto userDto, Model model) {
        UserDto userDto1 = this.userService.getUserByEmail(userDto.getEmail());
        if (userDto.getEmail().equals(userDto1.getEmail())) {
            if (userDto.getPassword().equals(userDto1.getPassword())) {
                return "en/welcomeUser";
            } else {
                model.addAttribute("loginMessage", "wrong pass");
            }
        } else {
            model.addAttribute("loginMessage", "No email found");
            return "en/userlogin";
        }
        return "en/userlogin";
    }
}
