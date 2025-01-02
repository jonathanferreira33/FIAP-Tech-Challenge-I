package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest2;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;

import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import com.fiap.Tech_Challenge_I.core.port.IUserManagementServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/usermanagement", produces = {"application/json"})
/*@Tag(name = "TechChallenge")*/
public class UserManagementController {
    private final UserConverter userConverter;
    private final IRegisterUserServicePort registerServiceport;
    private final IUserManagementServicePort servicePort;

    public UserManagementController(IRegisterUserServicePort registerServiceport, UserConverter userConverter, IUserManagementServicePort servicePort) {
        this.userConverter = userConverter;
        this.registerServiceport = registerServiceport;
        this.servicePort = servicePort;
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

    @PutMapping("/editregistrationdatauser/{idUser}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ApiResponse<UserResponse>> editRegistrationDataUser(@PathVariable("idUser") Integer idUser,
                                                             @RequestBody UserRequest user)
    {
        User userCurrent = servicePort.findUserById(idUser);
        if (userCurrent == null)
            throw new IllegalArgumentException("Usuário não encontrado");

        userCurrent.setId(idUser);
        var userAtt = servicePort.editUser(userCurrent, user);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(ApiResponseFactory.success(UserConverter.userToUserReponse(userAtt)));
    }
}