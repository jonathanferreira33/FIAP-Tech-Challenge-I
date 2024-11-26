package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.IUserManagementServicePort;
import com.fiap.Tech_Challenge_I.core.port.IUserRepositoryPort;

public class UserManagementService implements IUserManagementServicePort {
    private final IUserRepositoryPort userRepositoryPort;

    public UserManagementService(IUserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User findUserById(Integer id) {
        return UserConverter.userEntityToUser(userRepositoryPort.findById(id));
    }
}
