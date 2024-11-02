package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.Product;

public interface IProductManagementServicePort {
    Product registerProduct(Product product);
}
