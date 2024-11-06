package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.request.ProductRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registerproduct")
public class RegisterProductController {
    private final ProductConverter productConverter;
    private final IProductManagementServicePort productManagementServicePort;

    public RegisterProductController(ProductConverter productConverter, IProductManagementServicePort productManagementServicePort) {
        this.productConverter = productConverter;
        this.productManagementServicePort = productManagementServicePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        var product = productManagementServicePort.registerProduct(ProductConverter.productRequestToProduct(productRequest));
        return ProductConverter.productToProductResponse(product);
    }
}
