package umc.study.validation.validator;




import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.MissionProgress;
import umc.study.repository.CeoRepository;
import umc.study.repository.MissionProgressRepository;
import umc.study.validation.annotation.ExistCeo;
import umc.study.validation.annotation.IsChallenging;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class IsChallengingValidator implements ConstraintValidator<IsChallenging, Long> {

    private final MissionProgressRepository missionProgressRepository;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(!missionProgressRepository.existsById(value)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }

        MissionProgress missionProgress = missionProgressRepository.findById(value)
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        if(missionProgress.getStatus().name().equals("CHALLENGING")){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}

