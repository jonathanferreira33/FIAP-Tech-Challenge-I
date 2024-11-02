package com.fiap.Tech_Challenge_I.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TCDB_ORDER")
public class OrderEntity {
    @Id
    @GeneratedValue
    private int idOrder;
    private String note;
    private Date startDate;
    private Date endDate;

    public OrderEntity() {
    }

    public OrderEntity(int idOrder, String note, Date startDate, Date endDate) {
        this.idOrder = idOrder;
        this.note = note;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
