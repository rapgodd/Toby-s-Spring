package com.giyeon.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExchangeRate {
    BigDecimal getExchangeRate(String currency) throws IOException;
}
