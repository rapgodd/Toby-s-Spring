package com.giyeon.hellospring.paymentServiceLayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TestObjectFactory {

    @Bean
    public PaymentService getPaymentService() {
        return new PaymentService(getExchangeRate());
    }

    @Bean
    public ExchangeRate getExchangeRate() {
        return new ExchangeRateStub(BigDecimal.valueOf(2000));
    }

}
