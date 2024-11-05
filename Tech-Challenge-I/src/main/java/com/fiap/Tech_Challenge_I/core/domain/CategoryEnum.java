package com.fiap.Tech_Challenge_I.core.domain;

public enum CategoryEnum {
    snack(1),follow_up(2),drink(3),dessert(4) ;

    private final int categoryEvent;

    CategoryEnum(int category){
        categoryEvent = category;
    }

    public int getStep() {
        return categoryEvent;
    }

    public static CategoryEnum fromCategory(int codigo) {
        for (CategoryEnum status : CategoryEnum.values()) {
            if (status.getStep() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido para Status: " + codigo);
    }
}