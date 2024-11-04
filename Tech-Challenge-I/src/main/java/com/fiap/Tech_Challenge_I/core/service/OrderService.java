package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;

import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryPort;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;

import java.util.List;

public class OrderService implements IOrderServicePort {

    private final IOrderRepositoryPort orderRepositoryPort;

    public OrderService(IOrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order registerOrder(Order order) {
        var newOrder = orderRepositoryPort.createOrder(OrderConverter.orderToOrderEntity(order));
        return OrderConverter.orderEntitytoOrder(newOrder);
    }

    @Override
    public List<Order> findAllOrders() {
        var ordersE = orderRepositoryPort.findAllOrder();
        return OrderConverter.orderEntitiesToOrders(ordersE);
    }

}