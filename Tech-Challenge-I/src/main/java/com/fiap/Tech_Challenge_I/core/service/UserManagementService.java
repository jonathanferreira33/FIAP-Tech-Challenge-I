package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest2;
import com.fiap.Tech_Challenge_I.core.domain.Role.UserRoleEnum;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.domain.UserTypeEnum;
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

    @Override
    public User findByUsername(String username) {
        return UserConverter.userEntityToUser(userRepositoryPort.findByUsername(username));
    }

    @Override
    public User editUser(User user, UserRequest userRequest) {
        UserEntity userAtt = UserConverter.userToUserEntity(user);
        userAtt.setFirstName(userRequest.firstName());
        userAtt.setLastName(userRequest.lastName());
        userAtt.setEmail(userRequest.email());

        if (userAtt.getUserType() == null)
            userAtt.setUserType(UserTypeEnum.customer);

        if(userAtt.getDoc() == null)
            userAtt.setDoc(userRequest.doc());

        userAtt.setUsername(userRequest.username());

        return UserConverter.userEntityToUser(userRepositoryPort.editUser(userAtt));
    }
}
