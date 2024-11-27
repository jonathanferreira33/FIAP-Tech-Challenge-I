package com.fiap.Tech_Challenge_I.core.domain;

import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.IOrderStatus;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.Incoming;

import java.time.LocalDateTime;
import java.util.List;

public class Order{
    private int idOrder;
    private IOrderStatus orderStatus;
    private LocalDateTime startDate;
    private LocalDateTime  endDate;
    private List<Product> products;
    private User user;

    public Order() {
    }

    public Order(int idOrder, LocalDateTime startDate, LocalDateTime endDate, List<Product> products) {
        this.idOrder = idOrder;
        this.orderStatus = new Incoming();
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public Order(LocalDateTime startDate, LocalDateTime endDate, List<Product> products) {
        this.orderStatus = new Incoming();
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public Order(int idOrder, IOrderStatus orderStatus, LocalDateTime startDate, LocalDateTime endDate, List<Product> products) {
        this.idOrder = idOrder;
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

    public IOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderStatus(IOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    public void incoming() {
        orderStatus.incoming(this);
    }

    public void ready(){
        orderStatus.ready(this);
    }

    public void verification(){
        orderStatus.verification(this);
    }

    public void delivery(){
        orderStatus.delivery(this);
    }
}




