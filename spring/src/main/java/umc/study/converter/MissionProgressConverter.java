package umc.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MissionProgress;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionProgressRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionProgressRequestDTO;
import umc.study.web.dto.MissionProgressResponseDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MissionProgressConverter {

    private final MissionRepository missionRepository;

    private final MemberRepository memberRepository;

    public static MissionProgressResponseDTO toDTO(MissionProgress missionProgress){
        return MissionProgressResponseDTO.builder()
                .missionProgressId(missionProgress.getId())
                .missionId(missionProgress.getMission().getId())
                .missionStatus(missionProgress.getStatus())
                .createdAt(missionProgress.getCreatedAt())
                .build();
    }

    public MissionProgress toMissionProgress(MissionProgressRequestDTO missionProgressRequestDTO, Long memberId){

        Mission mission = missionRepository.findById(missionProgressRequestDTO.getMissionId())
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return MissionProgress.builder()
                .mission(mission)
                .member(member)
                .build();
    }

    public MissionProgressResponseDTO.MissionProgressListDTO toMissionProgressListDTO(
            Page<MissionProgress> missionProgressList){

        List<MissionProgressResponseDTO> missionProgressResponseDTOList
                = missionProgressList.stream()
                .map(MissionProgressConverter::toDTO)
                .collect(Collectors.toList());

        return MissionProgressResponseDTO.MissionProgressListDTO.builder()
                .isLast(missionProgressList.isLast())
                .isFirst(missionProgressList.isFirst())
                .totalPage(missionProgressList.getTotalPages())
                .totalElements(missionProgressList.getTotalElements())
                .listSize(missionProgressResponseDTOList.size())
                .missionProgressList(missionProgressResponseDTOList)
                .build();
    }

}
