package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;

public class Order{
    private int idOrder;
    private String idUser;
    private OrderStatusEnum orderStatus;
    private String sandwich;
    private String followUp;
    private String drink;
    private String dessert;
    private  Date startDate;
    private Date endDate;

    public OrderResponse(int idOrder, int idUser, OrderStatusEnum orderStatus, String snack, String followUp, String drink, String dessert, Date startDate, Date endDate) {
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSandwich() {
        return sandwich;
    }

    public void setSandwich(String sandwich) {
        this.sandwich = sandwich;
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




