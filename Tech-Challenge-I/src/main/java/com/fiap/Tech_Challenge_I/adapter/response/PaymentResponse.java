package com.fiap.Tech_Challenge_I.adapter.response;

import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponse {

    private Integer id;
    private Integer orderId;
    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public PaymentResponse(Integer id, LocalDateTime endDate, LocalDateTime startDate, PaymentStatus status, BigDecimal amount, Integer orderId) {
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
        this.status = status;
        this.amount = amount;
        this.orderId = orderId;
    }

    public PaymentResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
