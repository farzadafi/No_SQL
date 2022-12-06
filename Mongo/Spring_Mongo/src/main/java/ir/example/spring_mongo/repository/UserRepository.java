package ir.example.spring_mongo.repository;

import ir.example.spring_mongo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
