package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.Ceo;
import umc.study.validation.annotation.ExistCeo;

import javax.validation.constraints.NotNull;

@Getter
public class StoreRequestDTO {

    @NotNull
    String name;

    @NotNull
    String address;

    Float score;

    @ExistCeo
    @NotNull
    Long ceoId;
}
