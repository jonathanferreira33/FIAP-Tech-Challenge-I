package com.fiap.Tech_Challenge_I.adapter.response;

import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderResponse {
    private int idOrder;
    private int idUser;
    private OrderStatusEnum orderStatus;
    private String snack;
    private String followUp;
    private String drink;
    private String dessert;
    private Date startDate;
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
