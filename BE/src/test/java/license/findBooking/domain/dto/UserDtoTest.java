package license.findBooking.domain.dto;

import license.findBooking.domain.enums.RoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoTest {

    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setRoleType(RoleType.USER);
    }

    @Test
    void testGetUserId() {
        assertEquals(1L, userDto.getUserId());
    }

    @Test
    void testGetFirstName() {
        assertEquals("John", userDto.getFirstName());
    }

    @Test
    void testGetLastName() {
        assertEquals("Doe", userDto.getLastName());
    }

    @Test
    void testGetEmail() {
        assertEquals("john.doe@example.com", userDto.getEmail());
    }

    @Test
    void testGetRoleType() {
        assertEquals(RoleType.USER, userDto.getRoleType());
    }
}