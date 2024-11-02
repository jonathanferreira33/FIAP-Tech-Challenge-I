package com.fiap.Tech_Challenge_I.adapter.response;

import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private int idProduct;
    private String productName;
    private Double price;
    private String shortDescription;
    private CategoryEnum category;

    public ProductResponse() {
    }

    public ProductResponse(int idProduct, String productName, Double price, String shortDescription, CategoryEnum category) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.shortDescription = shortDescription;
        this.category = category;
    }
}
