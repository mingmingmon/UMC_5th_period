package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Ceo;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.CeoRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    private final StoreConverter storeConverter;

    public Store addStore(StoreRequestDTO storeRequestDTO){

        Store newStore = storeConverter.toStore(storeRequestDTO);
        storeRepository.save(newStore);

        return newStore;
    }



}
