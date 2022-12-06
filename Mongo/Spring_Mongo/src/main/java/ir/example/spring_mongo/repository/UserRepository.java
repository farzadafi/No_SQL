package ir.example.spring_mongo.repository;

import ir.example.spring_mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
