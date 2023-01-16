package com.bsd.reviewsmicroservice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {

    private Review review;

    @BeforeEach
    public void setUp() {
        // initialize review object
        review = new Review(5, "Great place to stay", LocalDate.now(), 1L, 2L);
    }

    @Test
    public void testReviewId() {
        // set reviewId value
        review.setReviewId(1L);
        // assert reviewId value
        assertEquals(1L, review.getReviewId());
    }

    @Test
    public void testStars() {
        // assert stars value
        assertEquals(5, review.getStars());
    }

    @Test
    public void testComment() {
        // assert comment value
        assertEquals("Great place to stay", review.getComment());
    }

    @Test
    public void testTimestamp() {
        // assert timestamp value
        assertEquals(LocalDate.now(), review.getTimestamp());
    }

    @Test
    public void testAccommodationId() {
        // assert accommodationId value
        assertEquals(1L, review.getAccommodationId());
    }

    @Test
    public void testUserId() {
        // assert userId value
        assertEquals(2L, review.getUserId());
    }
}