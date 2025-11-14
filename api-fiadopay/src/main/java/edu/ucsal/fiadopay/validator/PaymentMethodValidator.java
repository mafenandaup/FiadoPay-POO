package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.PaymentMethod;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodValidator implements ConstraintValidator<PaymentMethod, String> {
    @Override
    public boolean isValid(String method, ConstraintValidatorContext constraintValidatorContext) {
        for (PaymentMethod.Methods m : PaymentMethod.Methods.values()) {
            if (m.name().equalsIgnoreCase(method)) {
            return true;
        }
    }
        return false;
    }
}
