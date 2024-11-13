package com.giyeon.hellospring.paymentServiceLayer;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class Payment {

    private Long orderId;
    private String currency;
    private BigDecimal foreignCurrencyAmount;
    private BigDecimal exchangeRate;
    private BigDecimal koreanWonCurrencyAmount;
    private LocalDateTime dueDate;

    public Payment(Long orderId, String currency, BigDecimal foreignCurrencyAmount, BigDecimal exchangeRate, BigDecimal koreanWonCurrencyAmount, LocalDateTime dueDate) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exchangeRate = exchangeRate;
        this.koreanWonCurrencyAmount = koreanWonCurrencyAmount;
        this.dueDate = dueDate;
    }

    public static Payment getPaymentByUserInputCurrency(Long orderId, String currency, BigDecimal foreignCurrencyAmount, Clock clock, ExchangeRate exchangeRate) throws IOException {
        BigDecimal wonExchangeRate = exchangeRate.getExchangeRate(currency);
        BigDecimal koreanWonPrice = foreignCurrencyAmount.multiply(wonExchangeRate);
        return new Payment(orderId, currency, foreignCurrencyAmount, wonExchangeRate, koreanWonPrice, LocalDateTime.now(clock).plusMinutes(30));
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public BigDecimal getKoreanWonCurrencyAmount() {
        return koreanWonCurrencyAmount;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public BigDecimal getConvertedAmount() {
        return this.foreignCurrencyAmount.multiply(this.exchangeRate);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exchangeRate=" + exchangeRate +
                ", koreanWonCurrencyAmount=" + koreanWonCurrencyAmount +
                ", dueDate=" + dueDate +
                '}';
    }
}
