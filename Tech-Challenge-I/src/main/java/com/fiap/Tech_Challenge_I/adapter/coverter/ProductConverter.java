package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.adapter.request.ProductRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public static ProductResponse productToProductResponse(Product product) {
        return new ProductResponse(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategory());
    }

    public static Product productRequestToProduct(ProductRequest product) {
        return new Product(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategory());
    }

    public static ProductEntity productToProductEntity(Product product) {
        return new ProductEntity(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategory());
    }
}
