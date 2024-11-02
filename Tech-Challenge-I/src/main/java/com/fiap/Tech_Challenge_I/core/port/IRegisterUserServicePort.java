package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.User;

public interface IRegisterUserServicePort {
    User registerUser(User user);
}
