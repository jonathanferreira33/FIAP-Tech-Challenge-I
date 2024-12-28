package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.CustomUserDetails;
import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.request.AuthenticationRequest;
import com.fiap.Tech_Challenge_I.adapter.response.TokenResponse;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.ITokenServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthenticationContoller {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final ITokenServicePort tokenServicePort;

    public AuthenticationContoller(ITokenServicePort tokenServicePort) {
        this.tokenServicePort = tokenServicePort;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest dataLogin){

        try {
            var userNamePassword = new UsernamePasswordAuthenticationToken(dataLogin.login(), dataLogin.password());
            var auth = this.authenticationManager.authenticate(userNamePassword);
            var token = tokenServicePort.generateToken(UserConverter.ObjectToUser((CustomUserDetails) auth.getPrincipal()));

            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponseFactory.success(new TokenResponse(token)));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponseFactory.error(e.getMessage()));
        }
    }
}