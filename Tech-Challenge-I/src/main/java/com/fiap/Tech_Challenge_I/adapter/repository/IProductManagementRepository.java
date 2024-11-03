package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductManagementRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByCategory(CategoryEnum category);
}
