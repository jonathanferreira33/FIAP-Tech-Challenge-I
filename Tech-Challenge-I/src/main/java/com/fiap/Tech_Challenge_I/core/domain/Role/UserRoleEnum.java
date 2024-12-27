package com.fiap.Tech_Challenge_I.core.domain.Role;

import com.fiap.Tech_Challenge_I.core.domain.CategoryEnum;

public enum UserRoleEnum {
    manager(0), admin(1), customer(2), delivery(3), guest(4), tech(5) ;

    private final int userRoleEvent;

    UserRoleEnum(int userRole) { userRoleEvent =  userRole; }

    public int getStep() {
        return userRoleEvent;
    }

    public static UserRoleEnum fromCategory(int codUserRole) {
        for (UserRoleEnum userRole : UserRoleEnum.values()) {
            if (userRole.getStep() == codUserRole) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Código inválido para role: " + codUserRole);
    }
}
