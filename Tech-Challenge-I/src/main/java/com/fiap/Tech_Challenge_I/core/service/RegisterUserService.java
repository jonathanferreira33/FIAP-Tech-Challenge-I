package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import com.fiap.Tech_Challenge_I.core.port.IUserRepositoryPort;


public class RegisterUserService implements IRegisterUserServicePort {

    private final IUserRepositoryPort userRepositoryPort;

    public RegisterUserService(IUserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserEntity registerUser(User user) {
        return userRepositoryPort.create(UserConverter.userToUserEntity(user));
    }
}
