package ir.example.spring_mongo.dto;

import ir.example.spring_mongo.model.Address;
import ir.example.spring_mongo.model.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private Address address;

    private List<String> favouriteSubjects;

    private LocalDateTime created;
}