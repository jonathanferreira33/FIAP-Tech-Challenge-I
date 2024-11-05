package com.fiap.Tech_Challenge_I.core.domain;

public enum OrderStepEnum {
    pre_order(1), payment(2), inPreparation(3), ready(4), delivery(5);

private final int orderStepEvent;

    OrderStepEnum(int orderStep) { orderStepEvent = orderStep;}

    public int getOrderStepEvent() {
        return orderStepEvent;
    }

    public static OrderStepEnum fromOrderStep(int codigo) {
        for (OrderStepEnum step : OrderStepEnum.values()) {
            if (step.getOrderStepEvent() == codigo) {
                return step;
            }
        }
        throw new IllegalArgumentException("Código inválido para Status: " + codigo);
    }
}
