package ir.example.spring_mongo.service.user;

import ir.example.spring_mongo.model.User;
import ir.example.spring_mongo.repository.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserServiceImpel implements UserService {

    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public UserServiceImpel(UserRepository userRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(User user) {
        user.setCreated(LocalDateTime.now());
        userRepository.insert(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByEmailWithCustomQuery(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query,User.class);
    }
}