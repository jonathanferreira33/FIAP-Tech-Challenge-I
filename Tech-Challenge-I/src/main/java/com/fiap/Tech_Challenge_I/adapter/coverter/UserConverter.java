package com.fiap.Tech_Challenge_I.adapter.coverter;

import com.fiap.Tech_Challenge_I.adapter.request.UserRequest;
import com.fiap.Tech_Challenge_I.adapter.response.UserResponse;
import com.fiap.Tech_Challenge_I.core.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public static User userRequestToUser(UserRequest userRequest){
        return new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail());
    }

    public static UserResponse userToUserReponse(User user){
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.isAdmin());
    }
}
