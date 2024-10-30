package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.Request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.Response.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registeruser")
public class RegisterUserController {

    @PostMapping
    public UserRequest createUser(@RequestBody UserRequest userRequest) {
        return userRequest;
    }
}
