package com.bsd.reviewsmicroservice.domain.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ReviewDtoTest {

    @Mock
    private UserDto userDto;

    private ReviewDto reviewDto;

    @BeforeEach
    public void setUp() {
        reviewDto = new ReviewDto();
        reviewDto.setReviewId(1L);
        reviewDto.setStars(2);
        reviewDto.setComment("comment");
        reviewDto.setTimestamp(LocalDate.now());
        reviewDto.setAccommodationId(3L);
        reviewDto.setUser(userDto);
    }

    @Test
    public void testGettersReviewDto() {
        assertEquals(1L, reviewDto.getReviewId());
        assertEquals(2, reviewDto.getStars());
        assertEquals("comment", reviewDto.getComment());
        assertEquals(LocalDate.now(), reviewDto.getTimestamp());
        assertEquals(3L, reviewDto.getAccommodationId());
        assertEquals(userDto, reviewDto.getUser());
    }
}