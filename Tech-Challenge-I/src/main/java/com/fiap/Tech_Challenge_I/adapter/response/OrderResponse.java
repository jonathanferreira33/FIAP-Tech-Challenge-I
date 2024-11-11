package com.fiap.Tech_Challenge_I.adapter.response;


import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.IOrderStatus;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class OrderResponse {
    private int idOrder;
    private IOrderStatus orderStatus;
    private Date startDate;
    private Date endDate;

    public OrderResponse() {
    }

    public OrderResponse(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderResponse(int idOrder, IOrderStatus orderStatus, Date startDate, Date endDate) {
        this.idOrder = idOrder;
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OrderResponse(IOrderStatus orderStatus, Date startDate, Date endDate) {
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public IOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(IOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
