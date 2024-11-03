package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productmanagement")
public class ProductManagementController {

    private final ProductConverter productConverter;
    private final IProductManagementServicePort productManagementServicePort;

    public ProductManagementController(ProductConverter productConverter, IProductManagementServicePort productManagementServicePort) {
        this.productConverter = productConverter;
        this.productManagementServicePort = productManagementServicePort;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductsByCategory(CategoryEnum category){
        return productManagementServicePort.findProductsByCategory(category);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse editProduct() {
        return new ProductResponse();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteProdutc() {
        return "Produto deletado com sucesso";
    }
}
