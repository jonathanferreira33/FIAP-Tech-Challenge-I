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
}
