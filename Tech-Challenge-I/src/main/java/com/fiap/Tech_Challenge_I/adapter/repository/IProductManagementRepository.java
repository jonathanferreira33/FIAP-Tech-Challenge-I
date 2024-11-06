package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductManagementRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryCode(int category);
}
