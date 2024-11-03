package com.giyeon.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
    public PaymentService getPaymentService() {
        return new PaymentService(getCachedExRate());
    }


}
