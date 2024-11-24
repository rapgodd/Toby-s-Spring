package com.giyeon.hellospring.paymentServiceLayer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestObjectFactory.class)
class PaymentServiceTestV2 {

    @Autowired PaymentService paymentService;
    @Autowired ExchangeRateStub exchangeRateStub;
    @Autowired Clock clock;

    @Test
    void prepare() throws IOException {
        testPrepare(paymentService,exchangeRateStub,clock);
        exchangeRateStub.setBigDecimal(BigDecimal.valueOf(2500));
        testPrepare(paymentService,exchangeRateStub,clock);
    }

    private static void testPrepare(PaymentService paymentService, ExchangeRateStub ex, Clock clock) throws IOException {

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);


        Assertions.assertThat(payment.getExchangeRate()).isEqualByComparingTo(ex.getExchangeRate("USD"));
        Assertions.assertThat(payment.getExchangeRate().multiply(payment.getForeignCurrencyAmount())).isEqualByComparingTo(payment.getConvertedAmount());
        System.out.println(ex.getExchangeRate("ISD"));
        Assertions.assertThat(payment.getDueDate()).isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
    }

}