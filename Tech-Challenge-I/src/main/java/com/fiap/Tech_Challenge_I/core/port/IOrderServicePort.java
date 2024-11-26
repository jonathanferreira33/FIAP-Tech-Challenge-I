package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.core.domain.Order;

import java.util.List;

public interface IOrderServicePort {
    Order registerOrder(Order order);
    List<Order> findAllOrders();
    Order findOrderById(Integer id);
    List<OrderEntity> findOrdersByUserId(Integer userId);
    List<OrderEntity> findOrdersByProductId(Integer productId);
}
