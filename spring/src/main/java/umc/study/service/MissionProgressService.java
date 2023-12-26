package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionProgressConverter;
import umc.study.domain.mapping.MissionProgress;
import umc.study.repository.MissionProgressRepository;
import umc.study.web.dto.MissionProgressRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionProgressService {

    private final MissionProgressRepository missionProgressRepository;

    private final MissionProgressConverter missionProgressConverter;

    public MissionProgress addMissionProgress(
            MissionProgressRequestDTO missionProgressRequestDTO,
            Long memberId){

        MissionProgress newMissionProgress = missionProgressConverter.toMissionProgress(missionProgressRequestDTO, memberId);

        return missionProgressRepository.save(newMissionProgress);
    }
}
