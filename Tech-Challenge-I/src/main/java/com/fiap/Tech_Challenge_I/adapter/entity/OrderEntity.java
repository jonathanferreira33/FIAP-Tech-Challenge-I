package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
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
    private int idUser;
    private OrderStatusEnum orderStatus;
    private String snack;
    private String followUp;
    private String drink;
    private String dessert;
    private Date startDate;
    private Date endDate;

    public OrderEntity() {
    }

    public OrderEntity(int idOrder, int idUser, String orderStatus, String snack, String followUp, String drink, String dessert, Date startDate, Date endDate) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.orderStatus = orderStatus;
        this.snack = snack;
        this.followUp = followUp;
        this.drink = drink;
        this.dessert = dessert;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
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
