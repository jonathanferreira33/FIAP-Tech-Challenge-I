package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryPort;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        var order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        Hibernate.initialize(order.getProducts());
        Hibernate.initialize(order.getUser());
        return Optional.of(order);
    }

    @Override
    public List<OrderEntity> findOrdersByProductId(Integer idProduct) {
        return orderRepository.findOrdersByProductId(idProduct);
    }

    @Override
    public List<OrderEntity> findOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void update(OrderEntity order) {
        orderRepository.save(order);
    }
}