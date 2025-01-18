package com.fiap.Tech_Challenge_I.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private int id;
    private Order order;
    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public Payment() {
    }

    public Payment(Order order, BigDecimal amount, PaymentStatus status) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.status = status;
        this.startDate = LocalDateTime.now();
    }

    public Payment(int id, Order order, BigDecimal amount, PaymentStatus status, LocalDateTime startDate) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.status = status;
        this.startDate = LocalDateTime.now();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
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
