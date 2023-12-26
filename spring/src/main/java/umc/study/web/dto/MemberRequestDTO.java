package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.enums.SocialType;

import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String password;

        String name;

        Integer gender;

        String address;

        String phone_number;

        String email;

        SocialType socialType;

        List<Long> preferCategory;
    }
}
