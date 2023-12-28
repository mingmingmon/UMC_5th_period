package umc.study.validation.validator;


import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {


    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ILLEGAL_PAGE_NUMBER.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
