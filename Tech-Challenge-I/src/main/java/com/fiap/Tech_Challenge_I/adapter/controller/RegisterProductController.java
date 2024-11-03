package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registerproduct")
public class RegisterProductController {
    private final ProductConverter productConverter;

    public RegisterProductController(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(){
        return new ProductResponse();
    }
}
