package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.Member;
import umc.study.validation.annotation.ExistStore;

import javax.validation.constraints.NotNull;

@Getter

public class ReviewRequestDTO {
    @NotNull
    String title;

    @NotNull
    String content;

    @NotNull
    Float start_point;

    @ExistStore
    @NotNull
    Long storeId;

    @NotNull
    Long memberId;
}
