package com.fiap.Tech_Challenge_I.adapter.request;

import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderRequest {
    private int idOrder;
    private UserResponse user;
    private Date startDate;
    private Date endDate;
    private List<ProductRequest> products;

    public OrderRequest() {
    }

    public OrderRequest(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderRequest(UserResponse user, Date startDate, Date endDate, List<ProductRequest> products) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}