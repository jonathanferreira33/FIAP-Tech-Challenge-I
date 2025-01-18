package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.request.ProductRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest){

        var product = productManagementServicePort
                .registerProduct(ProductConverter
                        .productRequestToProduct(productRequest));

        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(ApiResponseFactory.success(ProductConverter.productToProductResponse(product)));
    }

    @PostMapping(value = "/list")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<List<ProductResponse>>> createProducts(@RequestBody List<ProductRequest> productRequests){

        var products = productRequests.stream()
                .map(ProductConverter::productRequestToProduct)
                .map(productManagementServicePort::registerProduct)
                .map(ProductConverter::productToProductResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(products));
    }
}
