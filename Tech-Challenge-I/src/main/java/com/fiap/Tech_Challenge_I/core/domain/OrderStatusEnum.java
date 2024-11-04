package com.fiap.Tech_Challenge_I.core.domain;

public enum OrderStatusEnum {
    incoming(1), inPreparation(2), ready(3), delivered(4);

    private final int orderEvent;

    OrderStatusEnum(int order){
        orderEvent = order;
    }

    public int getOrderEvent() {
        return orderEvent;
    }
}
