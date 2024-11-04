package com.giyeon.hellospring.exchangeRateLayer;

import com.giyeon.hellospring.paymentServiceLayer.ExchangeRate;

import java.math.BigDecimal;

public class StaticExchangeRate implements ExchangeRate {
    @Override
    public BigDecimal getExchangeRate(String currency) {
        return BigDecimal.valueOf(1000);
    }
}
