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
public class PaymentTest {

    @Autowired
    Clock clock;
    @Autowired
    ExchangeRate exchangeRate;

    @Test
    void testPayment() throws IOException {
        Payment payment = Payment.getPaymentByUserInputCurrency(1L, "USD", BigDecimal.TEN, clock, exchangeRate);
        Assertions.assertThat(LocalDateTime.now(clock).plusMinutes(30)).isEqualTo(payment.getDueDate());

        BigDecimal wonExRate = exchangeRate.getExchangeRate("USD");
        Assertions.assertThat(payment.getKoreanWonCurrencyAmount()).isEqualTo(wonExRate.multiply(BigDecimal.TEN));
    }

}
