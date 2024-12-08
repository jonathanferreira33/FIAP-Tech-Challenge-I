package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.PaymentEntity;
import com.fiap.Tech_Challenge_I.core.port.IPaymentRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentRepositoryAdapter implements IPaymentRepositoryPort {

    private final IPaymentRepository paymentRepository;
    private final ModelMapper mapper;

    public PaymentRepositoryAdapter(IPaymentRepository paymentRepository, ModelMapper mapper){
        this.paymentRepository = paymentRepository;
        this.mapper = mapper;
    }


    @Override
    public PaymentEntity create(PaymentEntity payment) {
        PaymentEntity newPayment = paymentRepository
                .save(mapper.map(payment, PaymentEntity.class));
        return mapper.map(newPayment, PaymentEntity.class);
    }

    @Override
    public void update(PaymentEntity payment) {

    }

    @Override
    public PaymentEntity findById(Integer id) {

        Optional<PaymentEntity> paymentMatch = paymentRepository.findById(id);

        if (paymentMatch.isPresent())
            return paymentMatch.get();

        throw new RuntimeException("Pagamento não encontrado");
    }
}
