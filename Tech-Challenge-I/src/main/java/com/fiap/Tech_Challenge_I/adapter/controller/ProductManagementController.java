package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.factory.ApiResponseFactory;
import com.fiap.Tech_Challenge_I.adapter.request.ProductRequest;
import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;
import com.fiap.Tech_Challenge_I.adapter.response.ProductResponse;
import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;
import com.fiap.Tech_Challenge_I.core.port.IProductManagementServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @GetMapping("/getallproductscategory")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByCategory(@RequestParam CategoryEnum category){

        var listProducts = productManagementServicePort
                .findProductsByCategory(category.getStep());

        return ResponseEntity.status(HttpStatus.OK)
                        .body(ApiResponseFactory
                                .success(listProducts));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ApiResponse<ProductResponse>> editProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest)
    {
        var productEdit = productManagementServicePort.findProductById(id);

        if(productEdit == null)
            throw new IllegalArgumentException("Produto não encontrado");

        var product = productManagementServicePort.editProduct(id, ProductConverter.productRequestToProduct(productRequest));

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(ApiResponseFactory.success(ProductConverter.productToProductResponse(product)));
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<Void>> deleteProdutc(@PathVariable Integer id) {
        if(productManagementServicePort.findProductById(id) == null)
            throw new IllegalArgumentException("Produto não encontrado");

        productManagementServicePort.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseFactory.success("Produto deletado com sucesso"));
    }
}