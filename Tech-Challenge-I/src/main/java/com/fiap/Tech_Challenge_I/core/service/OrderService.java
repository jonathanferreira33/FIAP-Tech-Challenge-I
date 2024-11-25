package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;

import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.port.IOrderRepositoryPort;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderServicePort {

    private final IOrderRepositoryPort orderRepositoryPort;
    private final IProductManagementServicePort productManagementServicePort;

    public OrderService(IOrderRepositoryPort orderRepositoryPort, IProductManagementServicePort productManagementServicePort ) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.productManagementServicePort = productManagementServicePort;
    }

    @Override
    public Order registerOrder(Order order) {

        var listProducts = order.getProducts().stream()
                .map(Product::getIdProduct)
                .map(productManagementServicePort::findProductById)
                .toList();

        order.setProducts(listProducts);

        var newOrder = orderRepositoryPort.createOrder(OrderConverter.orderToOrderEntity(order));

        return OrderConverter.orderEntitytoOrder(newOrder);
    }

    @Override
    public List<Order> findAllOrders() {
        var ordersEntity = orderRepositoryPort.findAllOrder();
        return ordersEntity.stream().map(OrderConverter::orderEntitytoOrder).toList();
    }

    @Override
    public Order findOrderById(Integer id) {
        var orderE = orderRepositoryPort.findOrderById(id);

        if(orderE.isPresent())
            return OrderConverter.orderEntitytoOrder(orderE.get());

        return null;
    }

}