package com.fiap.Tech_Challenge_I.core.domain;

public enum DeliveryTypeEnum {
    INCOMING(1),
    READY(2),
    VERIFICATION(3),
    DELIVERY(4),
    COMPLETED(5);

    private final int deliveryEvent;

    DeliveryTypeEnum(int delivery){
        deliveryEvent = delivery;
    }

    public int getStep() {
        return deliveryEvent;
    }
}