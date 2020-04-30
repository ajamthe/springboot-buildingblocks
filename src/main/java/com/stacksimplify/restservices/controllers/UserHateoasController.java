package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List> getAllUsers() throws UserNotFoundException {
        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            Long userId = user.getId();
            user.add(linkTo(methodOn(this.getClass()).getUserById(userId)).withSelfRel());
            user.add(linkTo(methodOn(OrderHateoasController.class).getAllOrders(userId)).withRel("all-orders"));
        }
        return new ResponseEntity<List>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> optionalUser = userService.getUserById(id);
            User user = optionalUser.get();
            Long userId = user.getId();
            user.add(linkTo(methodOn(this.getClass()).getUserById(userId)).withSelfRel());
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
