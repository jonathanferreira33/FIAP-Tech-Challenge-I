package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;

public record PurchaseOrders(
        int idPurchaseOrders,
        Date startDate,
        Date endDate,
        String description,
        StepEnum stepEnum
) {
}
