package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreConverter;
import umc.study.domain.Ceo;
import umc.study.domain.Store;
import umc.study.repository.CeoRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final CeoRepository ceoRepository;

    private final StoreRepository storeRepository;

    private final StoreConverter storeConverter;

    public Store addStore(StoreRequestDTO storeRequestDTO){

        Store newStore = storeConverter.toStore(storeRequestDTO);
        storeRepository.save(newStore);

        return newStore;
    }

}
