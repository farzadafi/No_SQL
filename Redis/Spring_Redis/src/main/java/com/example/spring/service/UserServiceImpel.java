package com.example.spring.service;

import com.example.spring.model.User;
import com.example.spring.repository.UserRepository;

public class UserServiceImpel implements UserService{

    private final UserRepository repository;

    public UserServiceImpel(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(User user) {
        repository.save(user);
    }
}
