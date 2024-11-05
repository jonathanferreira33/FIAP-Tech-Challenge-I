package com.fiap.Tech_Challenge_I.core.domain;

public enum UserTypeEnum {
    customer(1), employee(2);

    private final int userT;

    UserTypeEnum(int userType){
        userT = userType;
    }

    public int getUserType() {
        return userT;
    }
}
