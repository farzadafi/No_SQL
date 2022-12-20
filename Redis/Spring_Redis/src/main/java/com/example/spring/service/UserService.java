package com.example.spring.service;

import com.example.spring.model.User;

public interface UserService {
    void register(User user);
    User findById(Integer username);
    User findByUsername(String username);
}
