package com.example.spring.mapper;

import com.example.spring.dto.UserDto;
import com.example.spring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDto userDto);
    UserDto modelToDto(User user);
}
