package com.fiap.Tech_Challenge_I.core.domain;

public enum OrderEnum {
    incoming(1), inPreparation(2), ready(3), delivered(4);

    private final int orderEvent;

    OrderEnum(int order){
        orderEvent = order;
    }

    public int getOrderEvent() {
        return orderEvent;
    }
}
