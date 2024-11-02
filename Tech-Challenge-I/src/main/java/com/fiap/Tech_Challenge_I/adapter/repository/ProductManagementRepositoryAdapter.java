package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.port.IProductRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductManagementRepositoryAdapter implements IProductRepositoryPort {

    private final IProductManagementRepository productManagementRepository;
    private final ModelMapper mapper;

    public ProductManagementRepositoryAdapter(IProductManagementRepository productManagementRepository, ModelMapper mapper) {
        this.productManagementRepository = productManagementRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductEntity create(ProductEntity product) {
        return null;
    }
}
