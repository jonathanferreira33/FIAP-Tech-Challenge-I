package com.fiap.Tech_Challenge_I.core.port;

import java.math.BigDecimal;

public interface IPaymentGateway {
    boolean process(BigDecimal amount);
}
