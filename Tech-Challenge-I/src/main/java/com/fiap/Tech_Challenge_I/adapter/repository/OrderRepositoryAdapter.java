package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class OrderRepositoryAdapter implements IOrderRepositoryPort {

    private final IOrderRepository orderRepository;
    private final ModelMapper mapper;

    public OrderRepositoryAdapter(IOrderRepository orderRepository, ModelMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        orderEntity newOrder = orderRepository
                .save(mapper.map(order, OrderEntity.class));
        return mapper.map(newOrder, OrderEntity.class);
    }

}