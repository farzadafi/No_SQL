package ir.example.spring_mongo.mapper;

import ir.example.spring_mongo.dto.UserDto;
import ir.example.spring_mongo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDto userDto);
    UserDto modelToDto(User user);
}
