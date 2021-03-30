package br.com.nutrition.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistConsultaValidator.class)
public @interface ExistConsulta {
    String message() default "Horario indisponivel";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
