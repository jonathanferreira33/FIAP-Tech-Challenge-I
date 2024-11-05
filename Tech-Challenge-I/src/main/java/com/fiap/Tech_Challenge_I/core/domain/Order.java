package com.fiap.Tech_Challenge_I.core.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class Order{
    private int idOrder;
    private User user;
    private OrderStatusEnum orderStatus;
    private String sandwich;
    private String followUp;
    private String snack;
    private String drink;
    private String dessert;
    private Date startDate;
    private Date endDate;
    private OrderStepEnum orderStep;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "userId")
    private PreOrder preOrder;


    public Order() {
    }

    public Order(int idOrder, User user, OrderStatusEnum orderStatus, String sandwich, String followUp, String snack, String drink, String dessert, Date startDate, Date endDate, OrderStepEnum orderStep) {
        this.idOrder = idOrder;
        this.user = user;
        this.orderStatus = orderStatus;
        this.sandwich = sandwich;
        this.followUp = followUp;
        this.snack = snack;
        this.drink = drink;
        this.dessert = dessert;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orderStep = orderStep;
    }

    public Order(int idOrder, User user, OrderStatusEnum orderStatus, String sandwich, String followUp, String snack, String drink, String dessert, Date startDate, Date endDate, OrderStepEnum orderStep, Payment payment, PreOrder preOrder) {
        this.idOrder = idOrder;
        this.user = user;
        this.orderStatus = orderStatus;
        this.sandwich = sandwich;
        this.followUp = followUp;
        this.snack = snack;
        this.drink = drink;
        this.dessert = dessert;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orderStep = orderStep;
        this.payment = payment;
        this.preOrder = preOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
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

    public OrderStepEnum getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(OrderStepEnum orderStep) {
        this.orderStep = orderStep;
    }
}




