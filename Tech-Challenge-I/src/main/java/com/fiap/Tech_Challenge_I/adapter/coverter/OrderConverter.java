package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
//import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
//import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public static OrderEntity orderToOrderEntity (Order order) {
        return new OrderEntity(order.getOrderStatus(), order.getSnack(), order.getFollowUp(), order.getDrink(), order.getDessert(), order.getStartDate(), order.getEndDate());
    }

    public static Order orderEntitytoOrder (OrderEntity order){
        return new Order(order.getOrderStatus(), order.getSnack(), order.getFollowUp(), order.getDrink(), order.getDessert(), order.getStartDate(), order.getEndDate());
    }

    public static Order orderRequestToOrder(OrderRequest orderRequest){
        return new Order(order.getOrderStatus(), order.getSnack(), order.getFollowUp(), order.getDrink(), order.getDessert(), order.getStartDate(), order.getEndDate());
    }

    public static OrderResponse orderToOrderResponse(Order order){
        return new OrderResponse(order.getOrderStatus(), order.getSnack(), order.getFollowUp(), order.getDrink(), order.getDessert(), order.getStartDate(), order.getEndDate());
    }
}
