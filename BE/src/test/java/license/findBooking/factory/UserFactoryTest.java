package license.findBooking.factory;

import license.findBooking.domain.User;
import license.findBooking.domain.dto.UserDto;
import license.findBooking.domain.enums.RoleType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserFactoryTest {

    @InjectMocks
    private UserFactory userFactory;

    @Test
    public void testToEntity() {
        // Given
        //    @Mock
        UserDto userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setRoleType(RoleType.USER);

        // When
        User user = userFactory.toEntity(userDto);

        // Then
        assertEquals(1L, user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(RoleType.USER, user.getRoleType());
    }
}