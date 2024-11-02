package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import com.fiap.Tech_Challenge_I.core.port.IProductRepositoryPort;

public class ProductManagementService implements IProductManagementServicePort {

    private final IProductRepositoryPort productRepositoryPort;

    public ProductManagementService(IProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product registerProduct(Product product) {
        var newProduct = productRepositoryPort.create(ProductConverter.productToProductEntity(product));
        return null;
    }
}
