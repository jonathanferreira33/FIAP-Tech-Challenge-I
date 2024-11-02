package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductManagementRepository extends JpaRepository<ProductEntity, Integer> {
}
