package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.PaymentEntity;
import com.fiap.Tech_Challenge_I.adapter.response.PaymentResponse;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.Payment;
import com.fiap.Tech_Challenge_I.core.domain.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentConverter {
    public static PaymentEntity paymentToPaymentEntity (Payment payment){
        return new PaymentEntity(
                OrderConverter.orderToOrderEntity(payment.getOrder()),
                payment.getAmount(),
                payment.getStartDate(),
                payment.getStatus()
        );
    }

    public static Payment paymentEntityToPayment(PaymentEntity paymentEntity){
        return new Payment(
                paymentEntity.getIdPayment(),
                OrderConverter.orderEntitytoOrder(paymentEntity.getOrder()),
                paymentEntity.getAmount(),
                paymentEntity.getStatus(),
                paymentEntity.getStartDate()
        );
    }

    public static PaymentResponse paymentToPaymentResponse(Payment payment){
        return new PaymentResponse(
                payment.getId(),
                payment.getEndDate(),
                payment.getStartDate(),
                payment.getStatus(),
                payment.getAmount(),
                payment.getOrder().getIdOrder()
        );
    }
}
