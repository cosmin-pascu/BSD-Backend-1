package com.bsd.reviewsmicroservice.service;

import com.bsd.reviewsmicroservice.domain.User;
import com.bsd.reviewsmicroservice.domain.dto.UserDto;
import com.bsd.reviewsmicroservice.factory.UserFactory;
import com.bsd.reviewsmicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserFactory userFactory;


    public Optional<User> createUser(UserDto userDto) {
        return Optional.of(userRepository.save(userFactory.toEntity(userDto)));
    }

    public Optional<User> editUser(UserDto userDto) {
        return userRepository.findByUserId(userDto.getUserId())
                .map(user -> userRepository.save(user.updateFields(userDto)));
    }
}
