package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.PaymentMethod;
import edu.ucsal.fiadopay.exceptions.InvalidMethodException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodValidator implements ConstraintValidator<PaymentMethod, String> {
    @Override
    public boolean isValid(String method, ConstraintValidatorContext constraintValidatorContext) {

        if (method == null) return false;

        try {
            PaymentMethod.Methods.valueOf(method);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
