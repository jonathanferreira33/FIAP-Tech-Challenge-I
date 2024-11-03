package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.UserTypeEnum;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usermanagement")
public class UserManagementController {
    private final UserConverter userConverter;
    private final IRegisterUserServicePort registerServiceport;

    public UserManagementController(IRegisterUserServicePort registerServiceport, UserConverter userConverter) {
        this.userConverter = userConverter;
        this.registerServiceport = registerServiceport;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUsersByDoc(String doc){
        var user = registerServiceport.userByDoc(doc);
        return new UserResponse(1,"", "", "", true, UserTypeEnum.kitchen, doc);
    }
}
