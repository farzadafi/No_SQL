package com.example.spring.controller;

import com.example.spring.dto.UserDto;
import com.example.spring.mapper.UserMapper;
import com.example.spring.model.User;
import com.example.spring.service.UserServiceImpel;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findUser")
    public UserDto findUser(@RequestParam int id) {
        User user = userService.findById(id);
        return UserMapper.INSTANCE.modelToDto(user);
    }

    @GetMapping("/findUserByUsername")
    public UserDto findUserByUsername(@RequestParam String username) {
        User user = userService.findByUsername(username);
        return UserMapper.INSTANCE.modelToDto(user);
    }
}
