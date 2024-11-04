package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;

public interface IOrderRepositoryPort {
    public OrderEntity createOrder(OrderEntity order);
}
