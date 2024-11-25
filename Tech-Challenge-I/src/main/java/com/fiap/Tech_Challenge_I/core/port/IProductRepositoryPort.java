package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepositoryPort {
    public ProductEntity create(ProductEntity product);
    public List<ProductEntity> findAllbyCategory(int category);
    public Optional<ProductEntity> findById(Integer id);
    public ProductEntity editProduct(Product product);
    public void delete(Integer id);
    public List<ProductEntity> findProductsByOrderId(int idOrder);
}
