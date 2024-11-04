package com.giyeon.hellospring.paymentServiceLayer;

import java.math.BigDecimal;
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
