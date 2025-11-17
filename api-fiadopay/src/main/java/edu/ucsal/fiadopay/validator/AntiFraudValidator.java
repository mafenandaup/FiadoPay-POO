package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.AntiFraud;
import edu.ucsal.fiadopay.controller.PaymentRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class AntiFraudValidator implements ConstraintValidator <AntiFraud, PaymentRequest> {

    private double limite = 5000.00; //fixo por agr

    @Override
    public void initialize(AntiFraud constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PaymentRequest request, ConstraintValidatorContext context) {
        if (request.amount() == null) {
            return true;
        }
        if (request.amount().doubleValue() > limite) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            "Valor acima do limite anti fraude: R$ " + limite + ". Tente novamente."
                    )
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
