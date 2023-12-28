package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MissionProgress;

public interface MissionProgressRepository extends JpaRepository<MissionProgress, Long> {
    Page<MissionProgress> findAllByMemberAndStatus(Member member, MissionStatus missionStatus, PageRequest pageRequest);

}
