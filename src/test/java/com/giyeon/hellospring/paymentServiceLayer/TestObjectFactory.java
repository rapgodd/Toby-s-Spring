package com.giyeon.hellospring.paymentServiceLayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration
public class TestObjectFactory {

    @Bean
    public PaymentService getPaymentService() {
        return new PaymentService(getExchangeRate(), getClock());
    }

    @Bean
    public ExchangeRate getExchangeRate() {
        return new ExchangeRateStub(BigDecimal.valueOf(2000));
    }

    @Bean
    public Clock getClock() {
        return Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

}
