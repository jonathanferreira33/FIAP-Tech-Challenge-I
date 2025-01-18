package com.fiap.Tech_Challenge_I.core.domain.OrderStatus;

import com.fiap.Tech_Challenge_I.core.domain.Order;

public class Canceled implements IOrderStatus {
    @Override
    public void canceled(Order order) {
        throw new IllegalArgumentException("Pedido já está em cancelado");
    }

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
