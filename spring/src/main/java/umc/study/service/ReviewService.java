package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewConverter reviewConverter;

    public Review postReview(ReviewRequestDTO reviewRequestDTO){
        Review newReview = reviewConverter.toReview(reviewRequestDTO);

        return reviewRepository.save(newReview);
    }
}
