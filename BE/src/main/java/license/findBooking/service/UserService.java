package license.findBooking.service;

import license.findBooking.domain.User;
import license.findBooking.domain.dto.UserDto;
import license.findBooking.factory.UserFactory;
import license.findBooking.repository.UserRepository;
import license.findBooking.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserFactory userFactory;

    private final SecurityService securityService;

    public Optional<User> createUser(UserDto userDto) {
        return Optional.of(userRepository.save(userFactory.toEntity(userDto)));
    }

    public Optional<User> editUser(UserDto userDto) {
        return userRepository.findByUserId(userDto.getUserId())
                .map(user -> userRepository.save(user.updateFields(userDto)));
    }

    public Optional<User> editUserRole(UserDto userDto) {
        return userRepository.findByEmail(userDto.getEmail())
                .map(user -> userRepository.save(user.updateRole(userDto)));
    }

    public Optional<User> getLoggedInUser() {
        return Optional.of(securityService.getLoggedInUser());
    }
}
