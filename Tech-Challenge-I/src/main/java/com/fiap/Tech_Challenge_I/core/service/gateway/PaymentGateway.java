package com.fiap.Tech_Challenge_I.core.service.gateway;

import com.fiap.Tech_Challenge_I.core.domain.Payment;
import com.fiap.Tech_Challenge_I.core.port.IPaymentGateway;


import java.util.Random;


public class PaymentGateway implements IPaymentGateway {
    @Override
    public boolean process(Payment amount) {
        // Local para chamar a API de pagamento
        Random random = new Random();

        double trueProbability = 0.8;

        return random.nextDouble() < trueProbability;
    }
}
