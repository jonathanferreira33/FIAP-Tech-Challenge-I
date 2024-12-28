package com.fiap.Tech_Challenge_I.core.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.ITokenServicePort;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.*;
import java.util.Date;

public class TokenService implements ITokenServicePort {

    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("tech-challenge")
                    .withSubject(user.getUserName())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("tech-challenge")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTCreationException exception){
            return "";
        }
    }

    private Date generateExpirationDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiration = now.plusMinutes(120);
        return Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant());
    }
}
