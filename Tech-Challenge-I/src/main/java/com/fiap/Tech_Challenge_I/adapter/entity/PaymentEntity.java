package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TCDB_PAYMENT")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPayment")
    private int idPayment;

    @OneToOne(mappedBy = "payment")
    private OrderEntity order;

    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public PaymentEntity() {
        this.status = PaymentStatus.PENDING;
    }

    public PaymentEntity(OrderEntity order, BigDecimal amount, LocalDateTime startDate) {
        this.order = order;
        this.amount = amount;
        this.startDate = startDate;
        this.status = PaymentStatus.PENDING;
    }

    public PaymentEntity(OrderEntity order, BigDecimal amount, LocalDateTime startDate, PaymentStatus status) {
        this.order = order;
        this.amount = amount;
        this.startDate = startDate;
        this.status = status;
        this.endDate = LocalDateTime.now();
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
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
