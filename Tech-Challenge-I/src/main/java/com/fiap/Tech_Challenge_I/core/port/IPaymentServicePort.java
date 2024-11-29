package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.Payment;

import java.math.BigDecimal;

public interface IPaymentServicePort {
    public Payment processPayment(Order order, BigDecimal amount);
}
