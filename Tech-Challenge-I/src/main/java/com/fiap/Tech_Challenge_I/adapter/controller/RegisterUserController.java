package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/registeruser")
public class RegisterUserController {

    private final IRegisterUserServicePort registerServiceport;
    private final UserConverter userConverter;

    public RegisterUserController(IRegisterUserServicePort registerServiceport, UserConverter userConverter) {
        this.registerServiceport = registerServiceport;
        this.userConverter = userConverter;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {

        var user = registerServiceport.registerUser(UserConverter.userRequestToUser(userRequest));

        return UserConverter.userToUserReponse(user);
    }
}
