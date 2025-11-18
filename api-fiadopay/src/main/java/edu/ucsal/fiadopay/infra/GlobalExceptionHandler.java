package edu.ucsal.fiadopay.infra;

import edu.ucsal.fiadopay.exceptions.InvalidMethodException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage()).toString();

        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(InvalidMethodException.class)
    private ResponseEntity<RestErrorMsg> invalidPaymentHandler(InvalidMethodException e){
        RestErrorMsg errorMessage = new RestErrorMsg(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);    }
}
