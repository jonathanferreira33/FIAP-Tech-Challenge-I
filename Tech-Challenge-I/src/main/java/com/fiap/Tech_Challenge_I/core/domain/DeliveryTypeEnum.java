package com.fiap.Tech_Challenge_I.core.domain;

public enum DeliveryTypeEnum {
    withdraw(1),delivery(2);

    private final int deliveryEvent;

    DeliveryTypeEnum(int delivery){
        deliveryEvent = delivery;
    }

    public int getStep() {
        return deliveryEvent;
    }
}