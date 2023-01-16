package com.bsd.reviewsmicroservice.factory;

import com.bsd.reviewsmicroservice.domain.Review;
import com.bsd.reviewsmicroservice.domain.User;
import com.bsd.reviewsmicroservice.domain.dto.ReviewDto;
import com.bsd.reviewsmicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewFactory {

    private final UserRepository userRepository;

    public Review toEntity(ReviewDto reviewDto) {
        Review review = new Review();

        review.setReviewId(reviewDto.getReviewId());
        review.setStars(reviewDto.getStars());
        review.setComment(reviewDto.getComment());
        review.setTimestamp(reviewDto.getTimestamp());
        User user = userRepository.findByEmail(reviewDto.getUser().getEmail()).get();
        review.setUserId(user.getUserId());
        review.setAccommodationId(reviewDto.getAccommodationId());

        return review;
    }
}
