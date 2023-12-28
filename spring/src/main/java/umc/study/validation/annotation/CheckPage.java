package umc.study.validation.annotation;

import umc.study.validation.validator.CategoriesExistValidator;
import umc.study.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지가 음수 일 수는 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
