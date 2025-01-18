package com.fiap.Tech_Challenge_I.core.service;

import com.fiap.Tech_Challenge_I.adapter.coverter.OrderConverter;
import com.fiap.Tech_Challenge_I.adapter.coverter.PaymentConverter;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.Payment;
import com.fiap.Tech_Challenge_I.core.domain.PaymentStatus;
import com.fiap.Tech_Challenge_I.core.port.IOrderServicePort;
import com.fiap.Tech_Challenge_I.core.port.IPaymentGateway;
import com.fiap.Tech_Challenge_I.core.port.IPaymentRepositoryPort;
import com.fiap.Tech_Challenge_I.core.port.IPaymentServicePort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PaymentService implements IPaymentServicePort {

    private final IPaymentRepositoryPort paymentRepository;
    private final IPaymentGateway paymentGateway;
    private final IOrderServicePort orderServicePort;

    public PaymentService(IPaymentRepositoryPort paymentRepository, IPaymentGateway paymentGateway, IOrderServicePort orderServicePort) {
        this.paymentRepository = paymentRepository;
        this.paymentGateway = paymentGateway;
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Payment processPayment(int orderId, BigDecimal amount) {

        var order = orderServicePort.findOrderById(orderId);
        var newPayment = new Payment(order, amount, PaymentStatus.PENDING);

        var paymentData = paymentRepository
                .create(PaymentConverter.paymentToPaymentEntity(newPayment));

        Payment payment = PaymentConverter
                .paymentEntityToPayment(paymentData);

        order.setPayment(payment);
        orderServicePort.update(OrderConverter.orderToOrderEntity(order));

        boolean paymentResult = paymentGateway.process(payment);

        if (paymentResult)
            payment.setStatus(PaymentStatus.SUCCESS);
        else
            payment.setStatus(PaymentStatus.FAILED);

        payment.setEndDate(LocalDateTime.now());
        paymentRepository.update(PaymentConverter.paymentToPaymentEntity(payment));

        return payment;
    }
}
