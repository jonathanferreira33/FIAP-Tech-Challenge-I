package com.fiap.Tech_Challenge_I.core.port;

import com.fiap.Tech_Challenge_I.adapter.entity.PaymentEntity;

public interface IPaymentRepositoryPort {
    public PaymentEntity create(PaymentEntity payment);
}