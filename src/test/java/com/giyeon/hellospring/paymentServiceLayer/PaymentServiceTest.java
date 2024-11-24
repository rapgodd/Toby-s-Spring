package com.giyeon.hellospring.paymentServiceLayer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

class PaymentServiceTest {

    @Test
    void prepare() throws IOException {

        ExchangeRateStub ex = new ExchangeRateStub(BigDecimal.valueOf(2000));
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        PaymentService paymentService = new PaymentService(ex,clock);
        testPrepare(paymentService, ex, clock);

        ex.setBigDecimal(BigDecimal.valueOf(2500));
        testPrepare(paymentService, ex, clock);


    }

    private static void testPrepare(PaymentService paymentService, ExchangeRateStub ex, Clock clock) throws IOException {
        //when
        //1. 환율 정보를 잘 가져 와야 함.
        //2. 금액을 잘 계산 해야 함.
        //3. 유효시간이 잘 설정 되어 있어야 함.
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);


        //then
        //1. 환율 정보를 잘 가져 왔는지 확인
        //2. 금액을 잘 계산 했는지 확인
        //3. 유효시간이 잘 설정 되어 있는지 확인
        Assertions.assertThat(payment.getExchangeRate()).isEqualByComparingTo(ex.getExchangeRate("USD"));
        Assertions.assertThat(payment.getExchangeRate().multiply(payment.getForeignCurrencyAmount())).isEqualByComparingTo(payment.getConvertedAmount());
        System.out.println(ex.getExchangeRate("ISD"));
        Assertions.assertThat(payment.getDueDate()).isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
    }

}