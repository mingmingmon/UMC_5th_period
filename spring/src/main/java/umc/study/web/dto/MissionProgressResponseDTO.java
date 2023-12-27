package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionProgressResponseDTO {
    Long missionProgressId;

    Long missionId;

    MissionStatus missionStatus;

    LocalDateTime createdAt;
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionProgressListDTO{
        List<MissionProgressResponseDTO> missionProgressList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
