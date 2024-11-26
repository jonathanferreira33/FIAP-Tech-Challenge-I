package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {
    public static User userRequestToUser(UserRequest userRequest){
        return new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(), userRequest.getDoc());
    }

    public static UserResponse userToUserReponse(User user){
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.isAdmin(), user.getTipoUsuario(), formatDoc(user.getDoc()));
    }

    public static UserEntity userToUserEntity (User user) {
        return new UserEntity(user.getFirstName(), user.getLastName(), user.getEmail(), user.isAdmin(), user.getTipoUsuario(), user.getDoc());
    }

    public static User userEntityToUser (UserEntity user) {
        return new User(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isAdmin(),
                user.getTipoUsuario(),
                user.getDoc(),
                user.getOrders() != null ?
                        user.getOrders().stream().map(OrderConverter::orderEntitytoOrder).toList() :
                        List.of()
        );
    }

    private static String formatDoc(String doc){
        return doc.substring(0, 3) + ".***.***-" + doc.substring(9, 11);
    }
}
