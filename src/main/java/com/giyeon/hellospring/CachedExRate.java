package com.giyeon.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CachedExRate implements ExchangeRate {
    private final ExchangeRate exchangeRate;
    private BigDecimal cachedExRate;
    private LocalDateTime expiryTime;

    public CachedExRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public BigDecimal getExchangeRate(String currency) throws IOException {
        if (cachedExRate == null || expiryTime.isBefore(LocalDateTime.now())) {
            expiryTime = LocalDateTime.now().plusSeconds(3);
            cachedExRate = exchangeRate.getExchangeRate(currency);
            System.out.println("WebApi Called");
            return cachedExRate;
        }else{
            System.out.println("Cache Called");
            return cachedExRate;
        }
    }
}
