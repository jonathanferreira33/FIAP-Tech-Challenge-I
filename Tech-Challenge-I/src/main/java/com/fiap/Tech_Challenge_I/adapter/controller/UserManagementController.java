package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.UserTypeEnum;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usermanagement")
public class UserManagementController {
    private final UserConverter userConverter;
    private final IRegisterUserServicePort registerServiceport;

    public UserManagementController(IRegisterUserServicePort registerServiceport, UserConverter userConverter) {
        this.userConverter = userConverter;
        this.registerServiceport = registerServiceport;
    }

    @GetMapping("/userbydoc")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUsersByDoc( @RequestBody String doc){
        var user = registerServiceport.userByDoc(doc.replaceAll("[^0-9]", ""));

        if(user == null)
            throw new IllegalArgumentException("Usuário não encontrado");

        return UserConverter.userToUserReponse(user);
    }
}
