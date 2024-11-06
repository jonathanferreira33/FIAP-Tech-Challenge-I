package com.fiap.Tech_Challenge_I.core.domain;

public record Address(
        int idAddress,
        String address_name,
        String street,
        String name,
        String city,
        String zipCode
) {
}
