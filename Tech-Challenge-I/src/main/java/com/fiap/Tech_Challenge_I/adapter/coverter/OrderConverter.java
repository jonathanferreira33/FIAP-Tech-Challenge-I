package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
import com.fiap.Tech_Challenge_I.adapter.request.OrderRequest;
import com.fiap.Tech_Challenge_I.adapter.response.OrderResponse;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public static OrderEntity orderToOrderEntity (Order order) {
        return new OrderEntity(
                order.getIdOrder(),
                order.getOrderStatus(),
                order.getStartDate(),
                order.getProducts(),
                order.getUser()
        );
    }

    public static Order orderEntitytoOrder (OrderEntity order){
        return new Order(
                order.getIdOrder(),
                order.getStartDate(),
                order.getEndDate(),
                order.getProducts().stream().map(ProductConverter::productEntityToProduct).toList()
        );
    }

    public static Order orderRequestToOrder(OrderRequest order){
        return new Order(
                order.getIdOrder(),
                order.getStartDate(),
                order.getEndDate(),
                order.getProducts().stream().map(ProductConverter::productRequestToProduct).toList()
        );
    }

    public static OrderResponse orderToOrderResponse(Order order){
        return new OrderResponse(
                order.getIdOrder(),
                order.getOrderStatus(),
                order.getStartDate(),
                order.getProducts().stream().map(ProductConverter::productToProductResponse).toList(),
                UserConverter.userToUserReponse(order.getUser())
        );
    }

    public static OrderResponse orderEntityToOrderResponse(OrderEntity order){
        return new OrderResponse(
                order.getIdOrder(),
                order.getOrderStatus(),
                order.getStartDate(),
                order.getEndDate()
        );
    }
}
