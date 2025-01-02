package com.fiap.Tech_Challenge_I.adapter.request;

import com.fiap.Tech_Challenge_I.core.domain.Role.UserRoleEnum;
import com.fiap.Tech_Challenge_I.core.domain.UserTypeEnum;

public record UserRequest(int id,
        String firstName,
        String lastName,
        String email,
        boolean admin,
        UserTypeEnum tipoUsuario,
        String doc,
        String username,
        String password,
        UserRoleEnum role)
{}
