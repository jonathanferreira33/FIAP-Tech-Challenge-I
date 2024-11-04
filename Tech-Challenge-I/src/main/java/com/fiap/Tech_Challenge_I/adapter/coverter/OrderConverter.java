package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.OrderEntity;
//import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
//import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.adapter.request.OrderRequest;
import com.fiap.Tech_Challenge_I.adapter.response.OrderResponse;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderConverter {
    public static OrderEntity orderToOrderEntity (Order order) {
        return new OrderEntity(
                order.getIdOrder(),
                new UserEntity(order.getUser().getId()),
                order.getOrderStatus(),
                order.getSandwich(),
                order.getFollowUp(),
                order.getSnack(),
                order.getDrink(),
                order.getDessert(),
                order.getStartDate(),
                order.getEndDate()
        );
    }

    public static Order orderEntitytoOrder (OrderEntity order){
        return new Order(order.getIdOrder(),
                new User(order.getUser().getId()),
                order.getOrderStatus(),
                order.getSandwich(),
                order.getFollowUp(),
                order.getSnack(),
                order.getDrink(),
                order.getDessert(),
                order.getStartDate(),
                order.getEndDate());
    }

    public static Order orderRequestToOrder(OrderRequest order){
        return new Order(
                order.getIdOrder(),
                new User(order.getUser().getId()),
                order.getOrderStatus(),
                order.getSandwich(),
                order.getFollowUp(),
                order.getSnack(),
                order.getDrink(),
                order.getDessert(),
                order.getStartDate(),
                order.getEndDate()
        );
    }

    public static OrderResponse orderToOrderResponse(Order order){
        return new OrderResponse(
                order.getIdOrder(),
                new UserResponse(order.getUser().getId()),
                order.getOrderStatus(),
                order.getSandwich(),
                order.getFollowUp(),
                order.getSnack(),
                order.getDrink(),
                order.getDessert(),
                order.getStartDate(),
                order.getEndDate()
        );
    }

    public static OrderResponse orderEntityToOrderResponse(OrderEntity order){
        return new OrderResponse(
                order.getIdOrder(),
                new UserResponse(order.getUser().getId()),
                order.getOrderStatus(),
                order.getSandwich(),
                order.getFollowUp(),
                order.getSnack(),
                order.getDrink(),
                order.getDessert(),
                order.getStartDate(),
                order.getEndDate()
        );
    }

    public static List<OrderResponse> ordersToOrdersResponse (List<Order> orders){
        List<OrderResponse> ordersResponse = new ArrayList<>();
        for (Order order: orders){
            ordersResponse.add(orderToOrderResponse(order));
        }
        return ordersResponse;
    }

    public static List<Order> orderEntitiesToOrders (List<OrderEntity> ordersE) {
        List<Order> orders = new ArrayList<>();
        for (OrderEntity order: ordersE){
            orders.add(orderEntitytoOrder(order));
        }
        return orders;
    }
}
