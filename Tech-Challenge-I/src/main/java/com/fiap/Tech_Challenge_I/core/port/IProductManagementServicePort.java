package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;

import java.util.List;

public interface IProductManagementServicePort {
    Product registerProduct(Product product);
    List<ProductResponse> findProductsByCategory(Integer category);
    Product findProductById(Integer id);
    Product editProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    List<ProductResponse> findProductsByIdOrder(Integer idOrder);
}
