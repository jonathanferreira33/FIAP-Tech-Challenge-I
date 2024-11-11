package com.fiap.Tech_Challenge_I.core.domain.OrderStatus;

import com.fiap.Tech_Challenge_I.core.domain.Order;

public class Incoming implements IOrderStatus{
    @Override
    public void incoming(Order order) {
        throw new IllegalArgumentException("Entrada já registrada");
    }

    @Override
    public void ready(Order order) {
        order.setOrderStatus(new Ready());
    }

    @Override
    public void verification(Order order) {
        throw new IllegalArgumentException("Status não permitido");

    }

    @Override
    public void delivery(Order order) {
        throw new IllegalArgumentException("Status não permitido");

    }

    @Override
    public void completed(Order order) {
        throw new IllegalArgumentException("Status não permitido");
    }
}
