package com.fiap.Tech_Challenge_I.core.domain;

public record Product(
        int idProduct,
        String productName,
        Double price,
        String shortDescription
) {
}
