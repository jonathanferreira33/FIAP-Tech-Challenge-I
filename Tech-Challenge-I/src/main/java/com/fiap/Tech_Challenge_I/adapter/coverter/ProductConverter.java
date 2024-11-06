package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.adapter.request.ProductRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public static ProductResponse productToProductResponse(Product product) {
        return new ProductResponse(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategoryCode());
    }

    public static Product productRequestToProduct(ProductRequest product) {
        return new Product(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategoryCode());
    }

    public static ProductEntity productToProductEntity(Product product) {
        return new ProductEntity(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategoryCode());
    }

    public static Product productEntityToProduct(ProductEntity product) {
        return new Product(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategoryCode());
    }

    public static ProductResponse productEntityToProductResponse(ProductEntity product){
        return new ProductResponse(product.getIdProduct(), product.getProductName(), product.getPrice(), product.getShortDescription(), product.getCategoryCode());
    }

    public static List<ProductResponse> productEntitiesToProducts(List<ProductEntity> productEntities) {
        List<ProductResponse> products = new ArrayList<ProductResponse>();
        for(ProductEntity p: productEntities){
            products.add(productEntityToProductResponse(p));
        }
        return products;
    }

    public static List<Product> listProductsRequestToListProduct(List<ProductRequest> productsR){
        List<Product> products = new ArrayList<>();
        for (ProductRequest product: productsR){
            products.add(productRequestToProduct(product));
        }
        return products;
    }

    public static List<Product> listProductsEntityToProduct(List<ProductEntity> productsR){
        List<Product> products = new ArrayList<>();
        for (ProductEntity product: productsR){
            products.add(productEntityToProduct(product));
        }
        return products;
    }

    public static List<ProductEntity> listProductsToProductsEntity(List<Product> productsR){
        List<ProductEntity> products = new ArrayList<>();
        for (Product product: productsR){
            products.add(productToProductEntity(product));
        }
        return products;
    }

}
