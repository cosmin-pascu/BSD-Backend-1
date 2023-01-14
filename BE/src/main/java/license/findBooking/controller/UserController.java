package license.findBooking.controller;

import license.findBooking.domain.dto.UserDto;
import license.findBooking.repository.UserRepository;
import license.findBooking.service.UserService;
import license.findBooking.translator.UserTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final UserTranslator userTranslator;

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId) {
        return userRepository.findByUserId(userId)
                .map(user -> ResponseEntity.ok(userTranslator.generateUserDto(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/byEmail")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email)
                .map(user -> ResponseEntity.ok(userTranslator.generateUserDto(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userTranslator.generateUserDtoList(userRepository.findAll()));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto)
                .map(user -> ResponseEntity.ok(userTranslator.generateUserDto(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("")
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto) {
        return userService.editUser(userDto)
                .map(user -> ResponseEntity.ok(userTranslator.generateUserDto(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

}
