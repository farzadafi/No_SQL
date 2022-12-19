package com.example.spring.mapper;

import com.example.spring.dto.UserDto;
import com.example.spring.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T18:28:55+0330",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User dtoToModel(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.firstname( userDto.getFirstname() );
        user.lastname( userDto.getLastname() );
        user.username( userDto.getUsername() );

        return user.build();
    }

    @Override
    public UserDto modelToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstname( user.getFirstname() );
        userDto.setLastname( user.getLastname() );
        userDto.setUsername( user.getUsername() );

        return userDto;
    }
}
