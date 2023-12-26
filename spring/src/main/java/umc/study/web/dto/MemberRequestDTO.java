package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.enums.SocialType;
import umc.study.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        String password;

        @NotBlank
        String name;

        @NotNull
        Integer gender;

        @NotNull
        String address;

        @NotNull
        String phone_number;

        @NotNull
        String email;

        @NotNull
        SocialType socialType;

        @ExistCategories
        List<Long> preferCategory;
    }
}
