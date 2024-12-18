package com.giyeon.hellospring;

import com.giyeon.hellospring.exchangeRateLayer.CachedExRate;
import com.giyeon.hellospring.exchangeRateLayer.WebApiExchangeRate;
import com.giyeon.hellospring.paymentServiceLayer.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@ComponentScan
public class ObjectFactory {

    @Bean
    public CachedExRate getCachedExRate(){
        return new CachedExRate(getWebApiExchangeRate());
    }

    @Bean
    public WebApiExchangeRate getWebApiExchangeRate(){
        return new WebApiExchangeRate();
    }

    @Bean
    public Clock getClock(){
        return Clock.systemDefaultZone();
    }

    @Bean
    public PaymentService getPaymentService() {
        return new PaymentService(getCachedExRate(), getClock());
    }


}
