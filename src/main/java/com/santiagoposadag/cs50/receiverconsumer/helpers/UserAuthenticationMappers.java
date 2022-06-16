package com.santiagoposadag.cs50.receiverconsumer.helpers;

import com.santiagoposadag.cs50.receiverconsumer.collections.User;
import com.santiagoposadag.cs50.receiverconsumer.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserAuthenticationMappers {

    public Function<User, UserDTO> fromUserEntityToDTO() {
        return user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setDocument(user.getDocument());
            userDTO.setRoutingKey(user.getRoutingKey());
            return userDTO;
        };
    }

    public Function<UserDTO, User> fromDTOToUserEntity() {
        return userDTO -> {
            User user = new User();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setDocument(userDTO.getDocument());
            user.setRoutingKey(userDTO.getRoutingKey());
            return user;
        };
    }
}
