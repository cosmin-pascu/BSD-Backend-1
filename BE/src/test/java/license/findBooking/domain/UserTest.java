package license.findBooking.domain;

import license.findBooking.domain.dto.UserDto;
import license.findBooking.domain.enums.RoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private User user;
    private UserDto userDto;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setUserId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@example.com");
        user.setRoleType(RoleType.ADMIN);

        userDto = mock(UserDto.class);
        when(userDto.getEmail()).thenReturn("johndoe@example.com");
        when(userDto.getFirstName()).thenReturn("John");
        when(userDto.getLastName()).thenReturn("Doe");
        when(userDto.getRoleType()).thenReturn(RoleType.ADMIN);
    }

    @Test
    public void updateFieldsTest() {
        user.updateFields(userDto);
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastName(), userDto.getLastName());
    }

    @Test
    public void updateRoleTest() {
        user.updateRole(userDto);
        assertEquals(user.getRoleType(), userDto.getRoleType());
    }

    @Test
    public void testGetId() {
        assertEquals(1L, user.getUserId());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("johndoe@example.com", user.getEmail());
    }

    @Test
    public void testGetRoleType() {
        assertEquals(RoleType.ADMIN, user.getRoleType());
    }
}