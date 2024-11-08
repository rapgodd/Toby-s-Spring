package com.giyeon.hellospring.paymentServiceLayer;

import java.io.IOException;
import java.math.BigDecimal;

public class ExchangeRateStub implements ExchangeRate{
    public BigDecimal exRate;

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.exRate = bigDecimal;
    }

    public ExchangeRateStub(BigDecimal bigDecimal) {
        this.exRate = bigDecimal;
    }

    @Override
    public BigDecimal getExchangeRate(String currency) throws IOException {
        return this.exRate;
    }

}
