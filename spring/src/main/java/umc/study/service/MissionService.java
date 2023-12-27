package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    public Page<Mission> getStoreMissionList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));

        return missionPage;
    }
}
