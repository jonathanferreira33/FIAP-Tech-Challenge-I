package com.fiap.Tech_Challenge_I.adapter.controller;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.request.ProductRequest;
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

    @GetMapping("/getallproductscategory")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductsByCategory(@RequestParam CategoryEnum category){

        return productManagementServicePort.findProductsByCategory(category.getStep());
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductResponse editProduct( @PathVariable Integer id, @RequestBody ProductRequest productRequest)
    {
        var productEdit = productManagementServicePort.findProductById(id);
        if( productEdit == null)
            throw new IllegalArgumentException("Produto não encontrado");

        var product = productManagementServicePort.editProduct(id, ProductConverter.productRequestToProduct(productRequest));
        return ProductConverter.productToProductResponse(product);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProdutc(@PathVariable Integer id) {
        if(productManagementServicePort.findProductById(id) == null)
            throw new IllegalArgumentException("Produto não encontrado");

        productManagementServicePort.deleteProduct(id);
        return "Produto deletado com sucesso";
    }
}
