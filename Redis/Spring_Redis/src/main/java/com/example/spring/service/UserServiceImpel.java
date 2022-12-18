package com.example.spring.service;

import com.example.spring.exception.NotFoundException;
import com.example.spring.model.User;
import com.example.spring.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpel implements UserService {

    private final UserRepository repository;

    public UserServiceImpel(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(User user) {
        repository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id)
                .orElseThrow( () -> new NotFoundException(String.format("%s not found", id)));
    }
}
