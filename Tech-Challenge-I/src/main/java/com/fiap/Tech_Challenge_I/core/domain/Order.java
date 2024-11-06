package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;
import java.util.List;

public class Order{
    private int idOrder;
    private OrderStatusEnum orderStatus;
    private Date startDate;
    private Date endDate;
    private List<Product> products;

    public Order() {
    }

    public Order(int idOrder, OrderStatusEnum orderStatus, Date startDate, Date endDate, List<Product> products) {
        this.idOrder = idOrder;
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public Order(OrderStatusEnum orderStatus, Date startDate, Date endDate, List<Product> products) {
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
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




