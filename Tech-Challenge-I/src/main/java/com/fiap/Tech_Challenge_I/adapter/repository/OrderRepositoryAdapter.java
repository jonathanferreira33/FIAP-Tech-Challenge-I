package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


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
        OrderEntity newOrder = orderRepository
                .save(mapper.map(order, OrderEntity.class));
        return mapper.map(newOrder, OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> findOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderEntity> findOrdersByProductId(Integer idProduct) {
        return orderRepository.findOrdersByProductId(idProduct);
    }
}