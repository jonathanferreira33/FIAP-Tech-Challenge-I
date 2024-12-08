package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.core.domain.Payment;


public interface IPaymentGateway {
    boolean process(Payment amount);
}
