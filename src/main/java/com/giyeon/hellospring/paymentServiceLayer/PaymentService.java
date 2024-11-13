package com.giyeon.hellospring.paymentServiceLayer;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class PaymentService {
    private final ExchangeRate exchangeRate;
    private final Clock clock;

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public PaymentService(ExchangeRate exchangeRate, Clock clock) {
        this.clock = clock;
        this.exchangeRate = exchangeRate;
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {

        return Payment.getPaymentByUserInputCurrency(orderId, currency, foreignCurrencyAmount, clock, exchangeRate);

    }

}
