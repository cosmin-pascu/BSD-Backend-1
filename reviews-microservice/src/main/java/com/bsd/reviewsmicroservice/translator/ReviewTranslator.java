package com.bsd.reviewsmicroservice.translator;

import com.bsd.reviewsmicroservice.domain.Review;
import com.bsd.reviewsmicroservice.domain.dto.ReviewDto;
import com.bsd.reviewsmicroservice.domain.dto.UserDto;
import com.bsd.reviewsmicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewTranslator {

    private final UserTranslator userTranslator;
    private final UserRepository userRepository;

    public ReviewDto generateReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setReviewId(review.getReviewId());
        reviewDto.setStars(review.getStars());
        reviewDto.setComment(review.getComment());
        reviewDto.setTimestamp(review.getTimestamp());
        UserDto userDto = userTranslator.generateUserDto(userRepository.findByUserId(review.getUserId()).get());
        reviewDto.setUser(userDto);
        reviewDto.setAccommodationId(review.getAccommodationId());

        return reviewDto;
    }

    public List<ReviewDto> generateReviewDtoList(List<Review> reviews) {
        return reviews.stream()
                      .map(this::generateReviewDto)
                      .collect(Collectors.toList());
    }
}
