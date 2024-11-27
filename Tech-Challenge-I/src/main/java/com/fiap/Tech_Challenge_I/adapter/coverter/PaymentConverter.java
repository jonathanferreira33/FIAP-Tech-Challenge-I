package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.PaymentEntity;
import com.fiap.Tech_Challenge_I.core.domain.Payment;

public class PaymentConverter {
    public static PaymentEntity paymentToPaymentEntity (Payment payment){
        return new PaymentEntity();
    }
}
