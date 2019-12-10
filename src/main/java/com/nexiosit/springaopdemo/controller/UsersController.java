package com.nexiosit.springaopdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexiosit.springaopdemo.model.UserRequest;
import com.nexiosit.springaopdemo.model.UserResponse;

@RestController
@RequestMapping("/users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUser(@PathVariable final int userId) {
        LOGGER.info("Inside method UsersController.getUser");
        // retrieve user from service
        return new UserResponse(userId, "Fred", "Flintstone");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody final UserRequest user) {
        LOGGER.info("Inside method UsersController.createUser");
        // create user through service
        return new UserResponse(456, user.getFirstName(), user.getLastName());
    }
}
