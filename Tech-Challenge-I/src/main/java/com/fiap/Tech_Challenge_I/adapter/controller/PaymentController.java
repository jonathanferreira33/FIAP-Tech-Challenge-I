package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.PaymentConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.PaymentResponse;
import com.fiap.Tech_Challenge_I.core.port.IPaymentServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    private final IPaymentServicePort paymentServicePort;

    public PaymentController(IPaymentServicePort paymentService) {
        this.paymentServicePort = paymentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<PaymentResponse>> processPayment(@RequestParam int orderId,
                                                                       @RequestParam BigDecimal amount){

        var payment = paymentServicePort.processPayment(orderId,amount);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseFactory.success(
                        PaymentConverter.paymentToPaymentResponse(payment)
                ));
    }
}
