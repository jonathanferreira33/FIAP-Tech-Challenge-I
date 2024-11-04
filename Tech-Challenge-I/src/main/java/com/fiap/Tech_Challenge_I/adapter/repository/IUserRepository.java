package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByDoc(String doc);
}
