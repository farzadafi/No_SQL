package ir.example.spring_mongo.controller;

import ir.example.spring_mongo.dto.UserDto;
import ir.example.spring_mongo.exception.UserNotFoundException;
import ir.example.spring_mongo.mapper.UserMapper;
import ir.example.spring_mongo.model.User;
import ir.example.spring_mongo.service.user.UserServiceImpel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findByEmail")
    public ResponseEntity<UserDto> findByEmail(@RequestParam String email){
        User user = userServiceImpel.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("not Found!"));
        UserDto userDto = UserMapper.INSTANCE.modelToDto(user);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/findByEmailWithCustomQuery")
    public ResponseEntity<UserDto> findByEmailWithCustomQuery(@RequestParam String email){
        User user = userServiceImpel.findByEmailWithCustomQuery(email);
        if(user == null)
            throw new UserNotFoundException("not found!");
        UserDto userDto = UserMapper.INSTANCE.modelToDto(user);
        return ResponseEntity.ok(userDto);
    }
}
