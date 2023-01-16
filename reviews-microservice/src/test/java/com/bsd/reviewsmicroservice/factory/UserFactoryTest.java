package com.bsd.reviewsmicroservice.factory;

import com.bsd.reviewsmicroservice.domain.User;
import com.bsd.reviewsmicroservice.domain.dto.UserDto;
import com.bsd.reviewsmicroservice.domain.enums.RoleType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserFactoryTest {

    @InjectMocks
    private UserFactory userFactory;

    @Mock
    private UserDto userDto;

    @Test
    public void testToEntity() {
        when(userDto.getUserId()).thenReturn(1L);
        when(userDto.getFirstName()).thenReturn("John");
        when(userDto.getLastName()).thenReturn("Doe");
        when(userDto.getEmail()).thenReturn("johndoe@email.com");
        when(userDto.getRoleType()).thenReturn(RoleType.ADMIN);

        User user = new User();
        user.setUserId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@email.com");
        user.setRoleType(RoleType.ADMIN);

        assertEquals(user, userFactory.toEntity(userDto));
    }

}





















