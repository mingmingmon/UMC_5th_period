package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewConverter reviewConverter;

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    public Review postReview(ReviewRequestDTO reviewRequestDTO){
        Review newReview = reviewConverter.toReview(reviewRequestDTO);

        return reviewRepository.save(newReview);
    }

    public Page<Review> getReviewList(Long storeId, Integer page){

        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));

        return storePage;
    }

    public Page<Review> getMyReviewList(Long memberId, Integer page){

        Member member = memberRepository.findById(memberId).get();

        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return memberPage;
    }
}
