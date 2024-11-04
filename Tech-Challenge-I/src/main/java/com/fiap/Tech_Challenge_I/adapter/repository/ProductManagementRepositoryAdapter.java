package com.fiap.Tech_Challenge_I.adapter.repository;

import com.fiap.Tech_Challenge_I.adapter.entity.ProductEntity;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.port.IProductRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
    public List<ProductEntity> findAllbyCategory(CategoryEnum category) {
        return productManagementRepository.findByCategory(category);
    }

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        return productManagementRepository.findById(id);
    }

    @Override
    public ProductEntity EditProduct(Product product) {
        var producEdit = findById(product.getIdProduct());
        producEdit.setProductName(product.getProductName());
        producEdit.setPrice(product.getPrice());
        producEdit.setShortDescription(product.getShortDescription());
        producEdit.setCategory(product.getCategory());

        ProductEntity newProduct = productManagementRepository
                .save(mapper.map(producEdit, ProductEntity.class));
        return mapper.map(newProduct, ProductEntity.class);
    }
}
