package umc.study.web.dto;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MissionProgress;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMission;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class MissionProgressRequestDTO {
    @ExistMission
    @NotNull
    Long missionId;

    LocalDateTime createdAt;

}
