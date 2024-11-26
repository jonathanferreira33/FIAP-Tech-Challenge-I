package com.fiap.Tech_Challenge_I.core.domain;

public enum UserTypeEnum {
    customer(0), kitchen(1), conference(2), delivery(3);

    private final int userT;

    UserTypeEnum(int userType){
        userT = userType;
    }

    public int getUserType() {
        return userT;
    }

    public static UserTypeEnum fromUserType(int userType) {
        for (UserTypeEnum type : UserTypeEnum.values()) {
            if (type.getUserType() == userType) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo usuario invalido: " + userType);
    }
}
