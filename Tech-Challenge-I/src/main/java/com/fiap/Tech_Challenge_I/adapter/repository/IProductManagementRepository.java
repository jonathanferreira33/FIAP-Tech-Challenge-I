package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductManagementRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryCode(int category);

    @Query("SELECT p FROM ProductEntity p JOIN p.orders o WHERE o.idOrder = :idOrder")
    List<ProductEntity> findProductsByOrderId(@Param("idOrder") int idOrder);
}
