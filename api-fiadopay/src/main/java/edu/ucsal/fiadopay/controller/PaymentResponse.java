package edu.ucsal.fiadopay.controller;
import java.math.BigDecimal;
public record PaymentResponse(String id, String status, String method, BigDecimal amount, Integer installments, double interestRate, BigDecimal total, String message) {


}
