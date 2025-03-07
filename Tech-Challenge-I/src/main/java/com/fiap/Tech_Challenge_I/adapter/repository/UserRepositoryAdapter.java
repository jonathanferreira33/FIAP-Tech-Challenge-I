package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.core.domain.User;
import com.fiap.Tech_Challenge_I.core.port.IUserRepositoryPort;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public UserEntity findByDoc(String doc) {
        UserEntity userMatch = userRepository.findByDoc(doc);

        if(userMatch == null)
            return null;

        return mapper.map(userMatch, UserEntity.class);
    }

    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> userMatch =  userRepository.findById(id);

        if(userMatch.isPresent())
            return userMatch.get();

        throw new RuntimeException("User não encontrado");
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity userMatch = userRepository.findByUsername(username);

        if(userMatch == null)
            return null;

        return mapper.map(userMatch, UserEntity.class);
    }

    @Override
    public UserEntity editUser(UserEntity user) {

        UserEntity userMatch = userRepository.save(user);
        return mapper.map(userMatch, UserEntity.class);
    }
}