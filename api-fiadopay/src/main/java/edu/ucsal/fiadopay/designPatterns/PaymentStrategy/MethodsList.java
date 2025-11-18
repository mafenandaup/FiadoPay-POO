package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

public enum MethodsList {
    PIX,
    BOLETO,
    CREDITO,
    DEBITO;

    public static MethodsList fromString(String text) {
        if (text == null) {
            return null;
        }
        for (MethodsList method : MethodsList.values()) {
            if (method.name().equalsIgnoreCase(text)) {
                return method; // recebe o método de uma fonte de texto
            }
        }
        return null;
    }
}

