package com.bsd.reviewsmicroservice.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.bsd.reviewsmicroservice.domain.dto.UserDto;
import com.bsd.reviewsmicroservice.domain.enums.RoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserTest {

    @InjectMocks
    private User user;

    @Mock
    private UserDto userDto;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateFields() {
        when(userDto.getEmail()).thenReturn("example@example.com");
        when(userDto.getFirstName()).thenReturn("John");
        when(userDto.getLastName()).thenReturn("Doe");

        User updatedUser = user.updateFields(userDto);

        assertEquals("example@example.com", updatedUser.getEmail());
        assertEquals("John", updatedUser.getFirstName());
        assertEquals("Doe", updatedUser.getLastName());
    }

    @Test
    public void testUpdateRole() {
        when(userDto.getRoleType()).thenReturn(RoleType.USER);

        User updatedUser = user.updateRole(userDto);

        assertEquals(RoleType.USER, updatedUser.getRoleType());
    }
}