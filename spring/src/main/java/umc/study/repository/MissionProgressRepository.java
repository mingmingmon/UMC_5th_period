package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;
import umc.study.domain.mapping.MissionProgress;

public interface MissionProgressRepository extends JpaRepository<MissionProgress, Long> {
}