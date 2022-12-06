package ir.example.spring_mongo.controller;

import ir.example.spring_mongo.dto.UserDto;
import ir.example.spring_mongo.mapper.UserMapper;
import ir.example.spring_mongo.model.User;
import ir.example.spring_mongo.service.user.UserServiceImpel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpel userServiceImpel;

    public UserController(UserServiceImpel userServiceImpel) {
        this.userServiceImpel = userServiceImpel;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto){
        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        userServiceImpel.insert(user);
        return "OK";
    }
}
