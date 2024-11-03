package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;
import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryServicePort;
import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryPort;

public class OrderService implements IOrderServicePort {

    private final IOrderRepositoryPort orderRepositoryPort;

    public OrderService(IOrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order createOrder(Order order) {
        var newOrder = orderRepositoryPort.create(OrderConverter.orderToOrderEntity(order));
        return OrderConverter.orderEntityToOrder(newOrder);
    }
}