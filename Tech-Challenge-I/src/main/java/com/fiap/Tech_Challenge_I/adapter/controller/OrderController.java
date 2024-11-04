package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;
import com.fiap.Tech_Challenge_I.adapter.request.OrderRequest;
import com.fiap.Tech_Challenge_I.adapter.response.OrderResponse;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final IOrderServicePort orderServiceport;
    private final OrderConverter orderConverter;

    public OrderController(IOrderServicePort orderServiceport, OrderConverter orderConverter) {
        this.orderServiceport = orderServiceport;
        this.orderConverter = orderConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        var order = orderServiceport.createOrder(OrderConverter.orderRequestToOrder(orderRequest));
        return OrderConverter.orderToOrderReponse(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getAllOrders(){
        return new OrderResponse(1, 1, "", "", "", "", "", "", "");
    }

    //int idOrder, int idUser, OrderStatusEnum orderStatus, String snack, String followUp, String drink, String dessert, Date startDate, Date endDate)

}