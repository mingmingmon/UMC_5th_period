package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionProgressConverter;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MissionProgress;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionProgressRepository;
import umc.study.web.dto.MissionProgressRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionProgressService {

    private final MissionProgressRepository missionProgressRepository;

    private final MissionProgressConverter missionProgressConverter;

    private final MemberRepository memberRepository;

    public MissionProgress addMissionProgress(
            MissionProgressRequestDTO missionProgressRequestDTO,
            Long memberId){

        MissionProgress newMissionProgress = missionProgressConverter.toMissionProgress(missionProgressRequestDTO, memberId);

        return missionProgressRepository.save(newMissionProgress);
    }

    public Page<MissionProgress> getMyChallengingMissionList(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId).get();

        Page<MissionProgress> missionProgressPage
                = missionProgressRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));

        return missionProgressPage;
    }
}
