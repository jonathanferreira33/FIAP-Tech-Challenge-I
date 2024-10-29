package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;

public record Order(
        int idOrder,
        String note,
        Date startDate,
        Date endDate
) {
}
