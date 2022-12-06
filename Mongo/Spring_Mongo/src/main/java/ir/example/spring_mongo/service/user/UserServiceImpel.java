package ir.example.spring_mongo.service.user;

import ir.example.spring_mongo.model.User;
import ir.example.spring_mongo.repository.UserRepository;

import java.time.LocalDateTime;

public class UserServiceImpel implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User user) {
        user.setCreated(LocalDateTime.now());
        userRepository.insert(user);
    }
}
