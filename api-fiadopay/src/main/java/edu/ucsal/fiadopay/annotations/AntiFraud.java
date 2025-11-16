package edu.ucsal.fiadopay.annotations;

import edu.ucsal.fiadopay.validator.AntiFraudValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AntiFraudValidator.class)
public @interface AntiFraud {

    String message() default "Ação inválida dentro dos limites de transação. Tente novamente."; //msg de erro

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    // refatorar com classes strategy, uma com regra e outra com limite.. como podemos manter o validator?
}
