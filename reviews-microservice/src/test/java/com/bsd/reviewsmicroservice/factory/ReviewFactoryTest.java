package com.bsd.reviewsmicroservice.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import com.bsd.reviewsmicroservice.domain.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bsd.reviewsmicroservice.domain.dto.ReviewDto;
import com.bsd.reviewsmicroservice.domain.dto.UserDto;
import com.bsd.reviewsmicroservice.domain.enums.RoleType;
import com.bsd.reviewsmicroservice.domain.User;
import com.bsd.reviewsmicroservice.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class ReviewFactoryTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ReviewFactory reviewFactory;

    private ReviewDto reviewDto;

    private Review review;

    private User user;

    @BeforeEach
    public void setUp() {
        reviewDto = new ReviewDto();
        reviewDto.setReviewId(1L);
        reviewDto.setStars(5);
        reviewDto.setComment("comment");
        reviewDto.setTimestamp(LocalDate.of(2020, 1, 1));
        reviewDto.setAccommodationId(1L);
        UserDto userDto = new UserDto();
        userDto.setEmail("johndoe@email.com");
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setRoleType(RoleType.USER);
        reviewDto.setUser(userDto);
        user = new User();
        user.setUserId(1L);
        user.setEmail("johndoe@email.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setRoleType(RoleType.USER);

        review = new Review();
        review.setUserId(1L);
        review.setReviewId(1L);
        review.setStars(5);
        review.setComment("comment");
        review.setTimestamp(LocalDate.of(2020, 1, 1));
        review.setAccommodationId(1L);
    }

    @Test
    public void givenReviewDto_whenConvertToEntity_thenReturnReviewEntity() {
        when(userRepository.findByEmail("johndoe@email.com")).thenReturn(Optional.ofNullable(user));

        assertEquals(review, reviewFactory.toEntity(reviewDto));
    }
}