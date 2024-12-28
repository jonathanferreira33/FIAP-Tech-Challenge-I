package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;

public record Delivery(
        int idDelivery,
        String note,
        Date startDate,
        Date endDate,
        Address address,
        DeliveryTypeEnum deliveryType
) {
}