package com.fiap.Tech_Challenge_I.core.domain;

public enum UserTypeEnum {
    kitchen(1), conference(2), delivery(3);

    private final int userT;

    UserTypeEnum(int userType){
        userT = userType;
    }

    public int getUserType() {
        return userT;
    }
}
