package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import javax.validation.Valid;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/reviews")

public class ReviewController {

    private final ReviewService reviewService;

    private final ReviewConverter reviewConverter;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO> postReviews(
            @RequestBody @Valid ReviewRequestDTO reviewRequestDTO){
        Review review = reviewService.postReview(reviewRequestDTO);
        return ApiResponse.onSuccess(reviewConverter.toDTO(review));
    }
}
