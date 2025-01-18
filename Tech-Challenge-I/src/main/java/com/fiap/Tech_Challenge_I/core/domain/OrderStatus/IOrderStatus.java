package com.fiap.Tech_Challenge_I.core.domain.OrderStatus;

import com.fiap.Tech_Challenge_I.core.domain.Order;

public interface IOrderStatus {
    public void canceled(Order order);
    public void incoming(Order order);
    public void ready(Order order);
    public void verification(Order order);
    public void delivery(Order order);
    public void completed(Order order);
}
