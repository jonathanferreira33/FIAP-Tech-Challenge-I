package com.fiap.Tech_Challenge_I.core.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.ITokenServicePort;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

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

    private Instant generateExpirationDate() {
        return LocalDate.now().plus(Duration.ofMinutes(120)).atStartOfDay(ZoneId.systemDefault()).toInstant();
    }
}
