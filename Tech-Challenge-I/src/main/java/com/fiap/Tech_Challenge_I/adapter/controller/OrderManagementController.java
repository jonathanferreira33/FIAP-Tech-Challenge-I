package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;
import com.fiap.Tech_Challenge_I.adapter.response.OrderResponse;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderManagementController {

    private final IOrderServicePort orderServicePort;
    private final OrderConverter orderConverter;

    public OrderManagementController(IOrderServicePort orderServiceport, OrderConverter orderConverter) {
        this.orderServicePort = orderServiceport;
        this.orderConverter = orderConverter;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders(){
        var orders = orderServicePort.findAllOrders();
        return OrderConverter.ordersToOrdersResponse(orders);
    }

}