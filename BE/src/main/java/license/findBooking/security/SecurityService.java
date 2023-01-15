package license.findBooking.security;

import license.findBooking.domain.User;
import license.findBooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final UserRepository userRepository;

    public User getLoggedInUser() {
        UserInfo userPrincipal;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object principal = securityContext.getAuthentication().getPrincipal();

        if (principal instanceof UserInfo) {
            userPrincipal = ((UserInfo) principal);
        } else {
            throw new SecurityException("User not found in security context");
        }

        return userRepository.findByEmail(userPrincipal.getEmail())
                .orElseThrow(() -> new SecurityException("The user with email: " + userPrincipal.getEmail() + " doesn't exist"));
    }
}
