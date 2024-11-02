package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TCDB_PRODUCT")
public class ProductsEntity {

    @Id
    @GeneratedValue
    private int idProduct;
    private String productName;
    private Double price;
    private String shortDescription;
    private CategoryEnum category;

    public ProductsEntity() {
    }

    public ProductsEntity(int idProduct, String productName, Double price, String shortDescription, CategoryEnum category) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.shortDescription = shortDescription;
        this.category = category;
    }
}
