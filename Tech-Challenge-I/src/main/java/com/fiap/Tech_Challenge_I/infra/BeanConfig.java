package com.fiap.Tech_Challenge_I.infra;

import com.fiap.Tech_Challenge_I.core.port.*;
import com.fiap.Tech_Challenge_I.core.service.*;
import com.fiap.Tech_Challenge_I.core.service.gateway.PaymentGateway;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public IRegisterUserServicePort registerServiceImpl(IUserRepositoryPort userRepositoryPort) {
        return new RegisterUserService(userRepositoryPort);
    }

    @Bean
    public IProductManagementServicePort productManagementServiceImpl(IProductRepositoryPort productRepositoryPort){
        return new ProductManagementService(productRepositoryPort);
    }

    @Bean
    public IOrderServicePort orderServicePortImpl(IOrderRepositoryPort orderRepositoryPort, IProductManagementServicePort productManagementServicePort){
        return new OrderService(orderRepositoryPort, productManagementServicePort);
    }

    @Bean
    public IUserManagementServicePort userManagementServicePort(IUserRepositoryPort userRepositoryPort){
        return new UserManagementService(userRepositoryPort);
    }

    @Bean
    public IPaymentServicePort paymentServicePort(IPaymentRepositoryPort paymentRepositoryPort, IPaymentGateway paymentGateway, IOrderServicePort orderServicePort) {
        return new PaymentService(paymentRepositoryPort, paymentGateway, orderServicePort);
    }

    @Bean
    public IPaymentGateway paymentGateway(){
        return new PaymentGateway();
    }
}