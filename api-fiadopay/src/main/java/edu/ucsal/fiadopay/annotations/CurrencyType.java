package edu.ucsal.fiadopay.annotations;

import edu.ucsal.fiadopay.validator.CurrencyTypeValidator;
import edu.ucsal.fiadopay.validator.PaymentMethodValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrencyTypeValidator.class)

public @interface CurrencyType {

    String message() default "O tipo de moeda é inválido. Tente novamente."; //msg de erro

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
