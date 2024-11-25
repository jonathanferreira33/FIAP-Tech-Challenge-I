package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;

import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/usermanagement", produces = {"application/json"})
/*@Tag(name = "TechChallenge")*/
public class UserManagementController {
    private final UserConverter userConverter;
    private final IRegisterUserServicePort registerServiceport;

    public UserManagementController(IRegisterUserServicePort registerServiceport, UserConverter userConverter) {
        this.userConverter = userConverter;
        this.registerServiceport = registerServiceport;
    }


    @GetMapping("/userbydoc")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<UserResponse>> getUsersByDoc(@RequestBody String doc){
        var user = registerServiceport.userByDoc(doc.replaceAll("[^0-9]", ""));

        if(user == null)
            throw new IllegalArgumentException("Usuário não encontrado");

        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponseFactory.success(UserConverter.userToUserReponse(user)));
    }
}
