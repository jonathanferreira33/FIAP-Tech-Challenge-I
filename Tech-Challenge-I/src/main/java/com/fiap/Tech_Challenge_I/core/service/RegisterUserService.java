package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.IRegisterUserServicePort;
import com.fiap.Tech_Challenge_I.core.port.IUserRepositoryPort;


public class RegisterUserService implements IRegisterUserServicePort {

    private final IUserRepositoryPort userRepositoryPort;

    public RegisterUserService(IUserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User registerUser(User user) {

        var newUser = userRepositoryPort.create(UserConverter.userToUserEntityCreated(user));

        return UserConverter.userEntityToUser(newUser);
    }

    @Override
    public User userByDoc(String doc) {
        var user = userRepositoryPort.findByDoc(doc);

        if (user == null)
            return null;

        return UserConverter.userEntityToUser(user);
    }

}
