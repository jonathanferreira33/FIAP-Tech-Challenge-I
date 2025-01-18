package com.fiap.Tech_Challenge_I.adapter.request;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount
) {
}
