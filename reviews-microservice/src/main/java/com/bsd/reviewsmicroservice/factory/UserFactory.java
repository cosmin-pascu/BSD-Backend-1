package com.bsd.reviewsmicroservice.factory;

import com.bsd.reviewsmicroservice.domain.User;
import com.bsd.reviewsmicroservice.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User toEntity(UserDto userDto) {
        User user = new User();

        user.setUserId(userDto.userId);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRoleType(userDto.getRoleType());

        return user;
    }
}
