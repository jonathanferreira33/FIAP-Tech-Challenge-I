package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/registeruser", produces = {"application/json"})
public class RegisterUserController {

    private final IRegisterUserServicePort registerServiceport;
    private final UserConverter userConverter;

    public RegisterUserController(IRegisterUserServicePort registerServiceport, UserConverter userConverter) {
        this.registerServiceport = registerServiceport;
        this.userConverter = userConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest userRequest) {

        userRequest.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        var user = registerServiceport.registerUser(UserConverter.userRequestToUserCreated(userRequest));


        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponseFactory.success(UserConverter.userToUserReponseCreated(user)));
    }
}