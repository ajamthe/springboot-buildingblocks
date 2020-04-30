package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping(value = "/versioning/params/users/")
public class UserRequestParameterVersioningController {
    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;

    //Request parameter based Version 1
    @GetMapping(value = "/{id}", params = "version=1")
    public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> optionalUser = userService.getUserById(id);
            UserDtoV1 userDtoV1 = modelMapper.map(optionalUser.get(), UserDtoV1.class);
            return userDtoV1;
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    //Request parameter based Version 2
    @GetMapping(path = "/{id}", params = "version=2")
    public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> optionalUser = userService.getUserById(id);
            UserDtoV2 userDtoV2 = modelMapper.map(optionalUser.get(), UserDtoV2.class);
            return userDtoV2;
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
