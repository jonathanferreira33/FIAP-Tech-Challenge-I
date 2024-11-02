package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;

public interface IProductRepositoryPort {
    public ProductEntity create(ProductEntity product);
}
