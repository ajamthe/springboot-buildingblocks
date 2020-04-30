package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mapstruct/users")
public class UserMapStructController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @GetMapping
    public List<UserMsDto> getAllUserDtos() {
        return userMapper.usersToUserMsDtos(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserMsDto getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> optionalUser = userService.getUserById(id);
            return userMapper.userToUserMsDto(optionalUser.get());
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

}
