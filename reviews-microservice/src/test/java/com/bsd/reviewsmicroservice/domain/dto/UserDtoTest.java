package com.bsd.reviewsmicroservice.domain.dto;

import com.bsd.reviewsmicroservice.domain.enums.RoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserDtoTest {

    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setFirstName("fname");
        userDto.setLastName("lname");
        userDto.setEmail("name@email.com");
        userDto.setRoleType(RoleType.ADMIN);
    }

    @Test
    public void testGettersUserDto() {
        assertEquals(1L, userDto.getUserId());
        assertEquals("fname", userDto.getFirstName());
        assertEquals("lname", userDto.getLastName());
        assertEquals("name@email.com", userDto.getEmail());
        assertEquals(RoleType.ADMIN, userDto.getRoleType());
    }
}