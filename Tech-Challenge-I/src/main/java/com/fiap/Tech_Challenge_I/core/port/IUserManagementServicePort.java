package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.User;

public interface IUserManagementServicePort {
    User findUserById(Integer id);
    User findByUsername(String username);
}