package com.fiap.Tech_Challenge_I.core.domain;

public enum OrderStatusEnum {
    canceled(0), incoming(1), ready(2), verification(3), delivered(4), completed(5);

    private final int orderEvent;

    OrderStatusEnum(int order){
        orderEvent = order;
    }

    public int getOrderEvent() {
        return orderEvent;
    }
}