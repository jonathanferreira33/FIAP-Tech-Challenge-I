package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import com.fiap.Tech_Challenge_I.core.port.IProductRepositoryPort;

import java.util.List;


public class ProductManagementService implements IProductManagementServicePort {

    private final IProductRepositoryPort productRepositoryPort;

    public ProductManagementService(IProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product registerProduct(Product product) {
        var newProduct = productRepositoryPort.create(ProductConverter.productToProductEntity(product));
        return ProductConverter.productEntityToProduct(newProduct);
    }

    @Override
    public List<ProductResponse> findProductsByCategory(CategoryEnum category) {
        var productsEntity = productRepositoryPort.findAllbyCategory(category);
        return ProductConverter.productEntitiesToProducts(productsEntity);
    }
}
