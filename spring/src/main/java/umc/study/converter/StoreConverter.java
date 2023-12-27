package umc.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.domain.Ceo;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.CeoRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreConverter {
    private final CeoRepository ceoRepository;

    private final StoreRepository storeRepository;

    public StoreResponseDTO toDTO(Store store){
        return StoreResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public Store toStore(StoreRequestDTO storeRequestDTO){
        Ceo ceo = ceoRepository.findById(storeRequestDTO.getCeoId())
                .orElseThrow(() -> new RuntimeException("Ceo not found"));

        return Store.builder()
                .name(storeRequestDTO.getName())
                .address(storeRequestDTO.getAddress())
                .score(storeRequestDTO.getScore())
                .ceo(ceo)
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .writerNickname(review.getMember().getName())
                .star_point((review.getStar_point()))
                .createdAt(review.getCreatedAt())
                .context(review.getContent())
                .build();
    }
}
