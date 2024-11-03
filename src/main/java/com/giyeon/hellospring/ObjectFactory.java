package com.giyeon.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ObjectFactory {

    @Bean
    public PaymentService returnExchangeRateObject(){
        return new PaymentService(getExchangeRate());
    }

    @Bean
    public ExchangeRate getExchangeRate() {
        return new WebApiExchangeRate();
    }

}
