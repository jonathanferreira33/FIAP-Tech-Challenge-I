package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface IOrderRepositoryPort {
    public OrderEntity createOrder(OrderEntity order);
    public List<OrderEntity> findAllOrder();
    public Optional<OrderEntity> findOrderById(Integer id);
    public List<OrderEntity> findOrdersByProductId(Integer idProduct);
    public List<OrderEntity> findOrdersByUserId(Integer userId);
}
