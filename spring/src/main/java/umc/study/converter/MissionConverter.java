package umc.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MissionConverter {

    private final StoreRepository storeRepository;

    public static MissionResponseDTO toDTO(Mission mission){
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public Mission toMission(MissionRequestDTO missionRequestDTO){

        Store store = storeRepository.getById(missionRequestDTO.getStoreId());

        return Mission.builder()
                .title(missionRequestDTO.getTitle())
                .content(missionRequestDTO.getContent())
                .deadline(missionRequestDTO.getDeadline())
                .store(store)
                .build();
    }

    public MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList){
        List<MissionResponseDTO> missionResponseDTOList
                = missionList.stream()
                .map(MissionConverter::toDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionResponseDTOList.size())
                .misisonList(missionResponseDTOList)
                .build();
    }
}
