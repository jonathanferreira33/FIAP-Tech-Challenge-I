package com.fiap.Tech_Challenge_I.adapter.response;


import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.*;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private int idOrder;
    private OrderStatusEnum orderStatus;
    private Date startDate;
    private Date endDate;
    private List<ProductResponse> products;

    public OrderResponse() {
    }

    public OrderResponse(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderResponse(int idOrder, IOrderStatus orderStatus, Date startDate, Date endDate) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OrderResponse(int idOrder, IOrderStatus orderStatus, Date startDate, List<ProductResponse> products) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.products = products;
    }

    public OrderResponse(IOrderStatus orderStatus, Date startDate, Date endDate) {
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(IOrderStatus orderStatus) {
        this.orderStatus = convertStatusToType(orderStatus);
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

    private OrderStatusEnum convertStatusToType(IOrderStatus orderStatus) {
        if (orderStatus instanceof Canceled) return OrderStatusEnum.canceled;
        if (orderStatus instanceof Incoming) return OrderStatusEnum.incoming;
        if (orderStatus instanceof Ready) return OrderStatusEnum.ready;
        if (orderStatus instanceof Verification) return OrderStatusEnum.verification;
        if (orderStatus instanceof Delivery) return OrderStatusEnum.delivered;
        if (orderStatus instanceof Completed) return OrderStatusEnum.completed;
        throw new IllegalArgumentException("Unknown order status type");
    }
}
