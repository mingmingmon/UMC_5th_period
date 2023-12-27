package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistMission;
import umc.study.validation.annotation.IsChallenging;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class MissionRequestDTO {
    @NotNull
    String title;

    @NotNull
    String content;

    @NotNull
    LocalDate deadline;

    @NotNull
    Long storeId;
}
