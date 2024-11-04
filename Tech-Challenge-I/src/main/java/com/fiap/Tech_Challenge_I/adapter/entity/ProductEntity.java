package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TCDB_PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue
    private int idProduct;
    private String productName;
    private Double price;
    private String shortDescription;
    private CategoryEnum category;

    public ProductEntity() {
    }

    public ProductEntity(int idProduct, String productName, Double price, String shortDescription, CategoryEnum category) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.shortDescription = shortDescription;
        this.category = category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}

