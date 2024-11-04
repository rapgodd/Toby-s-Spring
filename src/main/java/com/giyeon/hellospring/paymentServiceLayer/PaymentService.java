package com.giyeon.hellospring.paymentServiceLayer;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {
    private final ExchangeRate exchangeRate;

    public PaymentService(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = exchangeRate.getExchangeRate(currency);
        BigDecimal koreanWonPrice = foreignCurrencyAmount.multiply(exRate);
        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, koreanWonPrice, LocalDateTime.now().plusMinutes(30));
    }

}
