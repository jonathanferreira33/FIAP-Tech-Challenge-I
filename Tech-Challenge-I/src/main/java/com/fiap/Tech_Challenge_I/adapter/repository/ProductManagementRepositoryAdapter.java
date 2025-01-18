package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.port.IProductRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        ProductEntity newProduct = productManagementRepository
                .save(mapper.map(product, ProductEntity.class));
        return mapper.map(newProduct, ProductEntity.class);
    }

    @Override
    public List<ProductEntity> findAllbyCategory(int category) {
        return productManagementRepository.findByCategoryCode(category);
    }



    @Override
    public Optional<ProductEntity> findById(Integer id) {
        return productManagementRepository.findById(id);
    }

    @Override
    public ProductEntity editProduct(Product product) {
        ProductEntity editProduct = productManagementRepository
                .save(mapper.map(product, ProductEntity.class));
        return mapper.map(editProduct, ProductEntity.class);
    }

    @Override
    public void delete(Integer id) {
        productManagementRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<ProductEntity> findProductsByOrderId(int idOrder) {
        return productManagementRepository.findProductsByOrderId(idOrder);
    }
}