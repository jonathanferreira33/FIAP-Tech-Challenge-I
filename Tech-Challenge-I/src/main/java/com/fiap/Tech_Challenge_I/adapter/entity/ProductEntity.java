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
    private int categoryCode;

    public ProductEntity() {
    }

    public ProductEntity(int idProduct, String productName, Double price, String shortDescription, int categoryCode) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.shortDescription = shortDescription;
        this.categoryCode = categoryCode;
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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public CategoryEnum getCategory() {
        return CategoryEnum.fromCategory(this.categoryCode);
    }

    public void setCategoryCode(CategoryEnum categoryCode) {
        this.categoryCode = categoryCode.getStep();
    }
}

