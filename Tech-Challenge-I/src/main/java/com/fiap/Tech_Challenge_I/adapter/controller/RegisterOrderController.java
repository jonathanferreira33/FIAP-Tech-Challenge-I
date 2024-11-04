package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;
import com.fiap.Tech_Challenge_I.adapter.request.OrderRequest;
import com.fiap.Tech_Challenge_I.adapter.response.OrderResponse;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registerorder")
public class RegisterOrderController {

    private final IOrderServicePort orderServicePort;
    private final OrderConverter orderConverter;

    public RegisterOrderController(IOrderServicePort orderServicePort, OrderConverter orderConverter) {
        this.orderServicePort = orderServicePort;
        this.orderConverter = orderConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        var order = orderServicePort.registerOrder(OrderConverter.orderRequestToOrder(orderRequest));
        return OrderConverter.orderToOrderResponse(order);
    }

}
