package com.fiap.Tech_Challenge_I.core.service.gateway;

import com.fiap.Tech_Challenge_I.core.port.IPaymentGateway;

import java.math.BigDecimal;


public class PaymentGateway implements IPaymentGateway {
    @Override
    public boolean process(BigDecimal amount) {
        // Local para chamar a API de pagamento
        return true;
    }
}
