package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.domain.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TCDB_PRE-ORDER")
public class PreOrderEntity {
    @Id
    @GeneratedValue
    private int id;
    private List<Product> products;
    @OneToOne
    @JoinColumn(name = "paymentId")
    private PaymentEntity payment;
    @OneToOne
    @JoinColumn(name = "userId")
    private User customer;

    public PreOrderEntity() {
    }
}
