package com.fiap.Tech_Challenge_I.core.domain.OrderStatus;

import com.fiap.Tech_Challenge_I.core.domain.Order;

public class Verification implements IOrderStatus{
    @Override
    public void incoming(Order order) {
        throw new IllegalArgumentException("Status não permitido");

    }

    @Override
    public void ready(Order order) {
        throw new IllegalArgumentException("Status não permitido");

    }

    @Override
    public void verification(Order order) {
        throw new IllegalArgumentException("Pedido já está em preparação");

    }

    @Override
    public void delivery(Order order) {
        order.setOrderStatus(new Delivery());
    }

    @Override
    public void completed(Order order) {
        throw new IllegalArgumentException("Status não permitido");
    }
}
