package com.fiap.Tech_Challenge_I.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "TCDB_PAYMENT")
public class PaymentEntity {

    @Id
    @GeneratedValue
    private int id;
    private Date paymentDate;
    private Boolean CheckPayment;

    public PaymentEntity() {
    }
}
