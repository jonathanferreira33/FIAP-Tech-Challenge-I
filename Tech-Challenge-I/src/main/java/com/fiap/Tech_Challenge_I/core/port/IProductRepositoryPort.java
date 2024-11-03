package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;

import java.util.List;

public interface IProductRepositoryPort {
    public ProductEntity create(ProductEntity product);
    public List<ProductEntity> findAllbyCategory(CategoryEnum category);
}
