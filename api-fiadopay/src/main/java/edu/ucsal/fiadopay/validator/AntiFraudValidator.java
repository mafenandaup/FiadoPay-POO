package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.AntiFraud;
import edu.ucsal.fiadopay.controller.PaymentRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AntiFraudValidator implements ConstraintValidator <AntiFraud, PaymentRequest> {

    private double limite;

    @Override
    public void initialize(AntiFraud constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PaymentRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (request.amount() == null) {
            return true;
        }
        if (request.amount().doubleValue() > limite) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            "Valor acima do limite anti fraude: R$ " + limite + ". Tente novamente."
                    ).addPropertyNode("amount")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
