package com.stacksimplify.restservices.mappers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "emailAddress")
    @Mapping(source = "role", target = "rolename")
    UserMsDto userToUserMsDto(User user);

    List<UserMsDto> usersToUserMsDtos(List<User> users);
}
