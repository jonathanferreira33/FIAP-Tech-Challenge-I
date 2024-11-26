package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.request.OrderRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.OrderResponse;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import com.fiap.Tech_Challenge_I.core.port.IUserManagementServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registerorder")
public class RegisterOrderController {

    private final IOrderServicePort orderServicePort;
    private final IProductManagementServicePort productManagementServicePort;
    private final IUserManagementServicePort userManagementServicePort;

    public RegisterOrderController(IOrderServicePort orderServicePort, IProductManagementServicePort productManagementServicePort, IUserManagementServicePort userManagementServicePort) {
        this.orderServicePort = orderServicePort;
        this.productManagementServicePort = productManagementServicePort;
        this.userManagementServicePort = userManagementServicePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody OrderRequest orderRequest) {

        if(orderRequest.getProducts().isEmpty())
            throw new IllegalArgumentException("Escolha ao menos 1 produto");


        var user = userManagementServicePort.findUserById(orderRequest.getUser().getId());

        var order = OrderConverter.orderRequestToOrder(orderRequest);
        order.setUser(user);

        var newOrder = orderServicePort.registerOrder(order);
        newOrder.setUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(OrderConverter.orderToOrderResponse(newOrder)));
    }
}