package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MissionProgress;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}