package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.Order;

public interface IOrderServicePort {
    Order registerOrder(Order order);
}
