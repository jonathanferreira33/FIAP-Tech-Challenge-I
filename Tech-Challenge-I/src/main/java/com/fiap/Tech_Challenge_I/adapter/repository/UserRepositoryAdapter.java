package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.IUserRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter implements IUserRepositoryPort {

    private final IUserRepository userRepository;
    private final ModelMapper mapper;

    public UserRepositoryAdapter(IUserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserEntity create(UserEntity user) {
        UserEntity newUser = userRepository
                .save(mapper.map(user, UserEntity.class));
        return mapper.map(newUser, UserEntity.class);
    }
}