package com.bsd.reviewsmicroservice.controller;

import com.bsd.reviewsmicroservice.domain.dto.ReviewDto;
import com.bsd.reviewsmicroservice.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    @Test
    public void testAddReview_badRequest() {
        when(reviewService.addReview(any(ReviewDto.class))).thenReturn(Optional.empty());
        ResponseEntity<ReviewDto> response = reviewController.addReview(new ReviewDto());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}