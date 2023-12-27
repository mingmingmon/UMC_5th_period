package umc.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.persistence.Convert;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewConverter {
    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    public  ReviewResponseDTO toDTO(Review review){
        return ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public  Review toReview(ReviewRequestDTO reviewRequestDTO){
        Member member = memberRepository.findById(reviewRequestDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found")); // 예외 처리는 상황에 따라 변경 가능

        Store store = storeRepository.getById(reviewRequestDTO.getStoreId());

        return Review.builder()
                .title(reviewRequestDTO.getTitle())
                .content(reviewRequestDTO.getContent())
                .store(store)
                .star_point(reviewRequestDTO.getStart_point())
                .member(member)
                .build();
    }

    public StoreResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .writerNickname(review.getMember().getName())
                .star_point((review.getStar_point()))
                .createdAt(review.getCreatedAt().toLocalDate())
                .context(review.getContent())
                .build();
    }

    public StoreResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList
                = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}
