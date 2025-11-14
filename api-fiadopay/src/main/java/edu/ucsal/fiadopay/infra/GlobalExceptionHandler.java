package edu.ucsal.fiadopay.infra;

import edu.ucsal.fiadopay.exceptions.InvalidMethodException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidMethodException.class)
    private ResponseEntity<RestErrorMsg> invalidPaymentHandler(InvalidMethodException e){
        RestErrorMsg errorMessage = new RestErrorMsg(HttpStatus.CONFLICT, e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);    }
}
