package com.example.spring.controller;

import com.example.spring.dto.UserDto;
import com.example.spring.mapper.UserMapper;
import com.example.spring.model.User;
import com.example.spring.service.UserServiceImpel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpel userService;

    public UserController(UserServiceImpel userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody UserDto userDto) {
        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        userService.register(user);
        return "OK";
    }
}
