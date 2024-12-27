package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;

public interface IUserRepositoryPort {
    public UserEntity create(UserEntity user);
    public UserEntity findByDoc(String doc);
    public UserEntity findById(Integer id);
    public UserEntity findByUsername(String username);
}