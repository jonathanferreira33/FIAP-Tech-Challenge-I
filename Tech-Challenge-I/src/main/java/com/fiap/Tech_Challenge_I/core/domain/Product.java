package com.fiap.Tech_Challenge_I.core.domain;


public class Product {
    private int idProduct;
    private String productName;
    private Double price;
    private String shortDescription;
    private int categoryCode;

    public Product() {
    }

    public Product(int idProduct, String productName, Double price, String shortDescription, int categoryCode) {
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

    public void setCategory(CategoryEnum categoryCode) {
        this.categoryCode = categoryCode.getStep();
    }
}
