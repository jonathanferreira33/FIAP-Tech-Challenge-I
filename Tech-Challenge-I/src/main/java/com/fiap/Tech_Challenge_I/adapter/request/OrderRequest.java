package com.fiap.Tech_Challenge_I.adapter.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {
    private int idOrder;
    private UserRequest2 user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<ProductRequest> products;


    public OrderRequest() {
        this.startDate = LocalDateTime.now();
    }

    public OrderRequest(List<ProductRequest> products) {
        this.startDate = LocalDateTime.now();
        this.products = products;
    }

    public OrderRequest(UserRequest2 user, List<ProductRequest> products) {
        this.user = user;
        this.startDate = LocalDateTime.now();
        this.products = products;
    }

    public List<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public UserRequest2 getUser() {
        return user;
    }

    public void setUser(UserRequest2 user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}