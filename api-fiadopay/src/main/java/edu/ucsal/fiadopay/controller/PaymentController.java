package edu.ucsal.fiadopay.controller;

import edu.ucsal.fiadopay.designPatterns.PaymentStrategy.PaymentProcessor;
import edu.ucsal.fiadopay.service.PaymentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.math.BigDecimal;

@RestController
@RequestMapping("/fiadopay/gateway")
@RequiredArgsConstructor
public class PaymentController {
  private final PaymentService service;

  @PostMapping("/payments")
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<PaymentResponse> create(
      @Parameter(hidden = true) @RequestHeader("Authorization") String auth,
      @RequestHeader(value="Idempotency-Key", required=false) String idemKey,
      @RequestBody @Valid PaymentRequest req
  ) {

      try {
          var resp = service.createPayment(auth, idemKey, req);
          return ResponseEntity.status(HttpStatus.CREATED).body(resp);


      } catch (IllegalArgumentException e) {
          return ResponseEntity.badRequest().body(
                  new PaymentResponse(idemKey, "ERRO", req.method(),
                          req.amount(), req.installments(),
                          null, null)
          );
      }
  }

  @GetMapping("/payments/{id}")
  public PaymentResponse get(@PathVariable String id) {
    return service.getPayment(id);
  }

  @PostMapping("/refunds")
  @SecurityRequirement(name = "bearerAuth")
  public java.util.Map<String,Object> refund(@Parameter(hidden = true) @RequestHeader("Authorization") String auth,
                                   @RequestBody @Valid RefundRequest body) {
    return service.refund(auth, body.paymentId());
  }
}
