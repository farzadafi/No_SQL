package ir.example.spring_mongo.service.user;

import ir.example.spring_mongo.model.User;

import java.util.Optional;

public interface UserService {
    void insert(User user);

    Optional<User> findByEmail(String email);

    User findByEmailWithCustomQuery(String email);

    Optional<User> findByEmailRegex(String emailRegex);
}
