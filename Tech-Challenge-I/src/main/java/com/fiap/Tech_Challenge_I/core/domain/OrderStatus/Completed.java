package com.fiap.Tech_Challenge_I.core.domain.OrderStatus;

import com.fiap.Tech_Challenge_I.core.domain.Order;

public class Completed implements IOrderStatus{
    @Override
    public void incoming(Order order) {
        throw new IllegalArgumentException("Pedido finalizado");
    }

    @Override
    public void ready(Order order) {
        throw new IllegalArgumentException("Pedido finalizado");
    }

    @Override
    public void verification(Order order) {
        throw new IllegalArgumentException("Pedido finalizado");
    }

    @Override
    public void delivery(Order order) {
        throw new IllegalArgumentException("Pedido finalizado");
    }

    @Override
    public void completed(Order order) {
        throw new IllegalArgumentException("Pedido finalizado");
    }
}