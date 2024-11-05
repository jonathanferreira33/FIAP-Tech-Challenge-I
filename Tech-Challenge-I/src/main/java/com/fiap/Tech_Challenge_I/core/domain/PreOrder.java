package com.fiap.Tech_Challenge_I.core.domain;

import com.fiap.Tech_Challenge_I.adapter.entity.PaymentEntity;

import java.util.List;

public class PreOrder {
    private Integer id;
    private List<Product> products;
    private PaymentEntity payment;
    private User customer;

    public PreOrder() {
    }

    public PreOrder(Integer id, List<Product> products, PaymentEntity payment, User customer) {
        this.id = id;
        this.products = products;
        this.payment = payment;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}