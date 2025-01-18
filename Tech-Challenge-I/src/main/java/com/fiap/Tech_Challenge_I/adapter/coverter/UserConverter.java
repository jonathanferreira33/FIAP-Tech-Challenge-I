package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.entity.UserEntity;
import com.fiap.Tech_Challenge_I.adapter.request.UserRequest2;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {
    public static User userRequestToUserCreated(UserRequest2 userRequest){
        return new User(userRequest.getLogin(), userRequest.getPassword());
    }

    public static User userRequestToUser(UserRequest2 userRequest){
        return new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(), userRequest.getDoc());
    }

    public static UserResponse userToUserReponseCreated(User user){
        return new UserResponse(user.getId(), user.getUserName());
    }

    public static UserResponse userToUserReponse(User user){
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.isAdmin(), user.getUserType(), formatDoc(user.getDoc()));
    }

    public static UserEntity userToUserEntityCreated(User user) {
        return new UserEntity(
                user.getUserName(),
                true,
                user.getPassword(),
                user.getRole()
        );
    }

    public static UserEntity userToUserEntity (User user) {
        return new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isAdmin(),
                user.getUserType(),
                user.getDoc(),
                user.getUserName(),
                user.isEnabled(),
                user.getRole(),
                user.getPassword()
        );
    }

    public static User userEntityToUser (UserEntity user) {
        return new User(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isAdmin(),
                user.getUserType(),
                user.getDoc(),
                user.getRole(),
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.getOrders() != null ?
                        user.getOrders().stream().map(OrderConverter::orderEntitytoOrder).toList() :
                        List.of()
        );
    }

    public static User ObjectToUser (CustomUserDetails  customUserDetails){
        return new User(
                customUserDetails.getUsername(),
                customUserDetails.getPassword(),
                customUserDetails.getAuthorities().toString(),
                customUserDetails.isEnabled()
        );
    }

    private static String formatDoc(String doc){
        return doc.substring(0, 3) + ".***.***-" + doc.substring(9, 11);
    }
}
