package umc.study.validation.validator;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.CeoRepository;
import umc.study.validation.annotation.ExistCeo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class CeoExistValidator implements ConstraintValidator<ExistCeo, Long> {

    private final CeoRepository ceoRepository;

    @Override
    public void initialize(ExistCeo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(!ceoRepository.existsById(value)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.CEO_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
