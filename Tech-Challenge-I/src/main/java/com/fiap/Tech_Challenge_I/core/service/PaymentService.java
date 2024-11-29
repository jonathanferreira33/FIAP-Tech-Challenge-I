package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.PaymentConverter;
import com.fiap.Tech_Challenge_I.core.domain.Payment;
import com.fiap.Tech_Challenge_I.core.domain.PaymentStatus;
import com.fiap.Tech_Challenge_I.core.port.IPaymentGateway;
import com.fiap.Tech_Challenge_I.core.port.IPaymentRepositoryPort;
import com.fiap.Tech_Challenge_I.core.port.IPaymentServicePort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService implements IPaymentServicePort {

    private final IPaymentRepositoryPort paymentRepository;
    private final IPaymentGateway paymentGateway;

    public PaymentService(IPaymentRepositoryPort paymentRepository, IPaymentGateway paymentGateway) {
        this.paymentRepository = paymentRepository;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment processPayment(String orderId, BigDecimal amount) {
        Payment payment = new Payment(null, orderId, amount, PaymentStatus.PENDING);
        paymentRepository.create(PaymentConverter.paymentToPaymentEntity(payment));

        boolean paymentResult = paymentGateway.process(amount);

        if (paymentResult)
            payment.setStatus(PaymentStatus.SUCCESS);
        else
            payment.setStatus(PaymentStatus.FAILED);

        /*paymentRepository.update(payment);*/
        return payment;
    }
}
