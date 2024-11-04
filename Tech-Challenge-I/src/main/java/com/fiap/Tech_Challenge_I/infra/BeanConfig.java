package com.fiap.Tech_Challenge_I.infra;

import com.fiap.Tech_Challenge_I.core.port.*;
import com.fiap.Tech_Challenge_I.core.service.OrderService;
import com.fiap.Tech_Challenge_I.core.service.ProductManagementService;
import com.fiap.Tech_Challenge_I.core.service.RegisterUserService;
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
    public IOrderServicePort orderServicePortImpl(IOrderRepositoryPort orderRepositoryPort){
        return new OrderService(orderRepositoryPort);
    }
}
