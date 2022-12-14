package com.example.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@RedisHash("user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;

    private String lastname;

    private String username;
}
