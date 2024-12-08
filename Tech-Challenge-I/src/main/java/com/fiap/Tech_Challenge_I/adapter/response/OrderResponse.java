package com.fiap.Tech_Challenge_I.adapter.response;


import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.*;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private int idOrder;
    private OrderStatusEnum orderStatus;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<ProductResponse> products;
    private UserResponse userResponse;

    public OrderResponse() {
    }

    public OrderResponse(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderResponse(int idOrder, IOrderStatus orderStatus, LocalDateTime startDate, LocalDateTime endDate) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OrderResponse(int idOrder, IOrderStatus orderStatus, LocalDateTime startDate, List<ProductResponse> products, UserResponse userResponse) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.products = products;
        this.userResponse = userResponse;
    }

    public OrderResponse(IOrderStatus orderStatus, LocalDateTime startDate, LocalDateTime endDate) {
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    private OrderStatusEnum convertStatusToType(IOrderStatus orderStatus) {
        if (orderStatus instanceof Canceled) return OrderStatusEnum.canceled;
        if (orderStatus instanceof Incoming) return OrderStatusEnum.incoming;
        if (orderStatus instanceof Ready) return OrderStatusEnum.ready;
        if (orderStatus instanceof Verification) return OrderStatusEnum.verification;
        if (orderStatus instanceof Delivery) return OrderStatusEnum.delivered;
        if (orderStatus instanceof Completed) return OrderStatusEnum.completed;
        throw new IllegalArgumentException("Status não encontrado");
    }
}
