package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.User;

public interface ITokenServicePort {
    public String generateToken(User user);
    public String validateToken(String token);
}
