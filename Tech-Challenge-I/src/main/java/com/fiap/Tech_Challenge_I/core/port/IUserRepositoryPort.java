package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.core.domain.User;

public interface IUserRepositoryPort {
    public UserEntity create(UserEntity user);
}
