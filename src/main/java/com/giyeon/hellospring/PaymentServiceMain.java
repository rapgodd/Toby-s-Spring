package com.giyeon.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class PaymentServiceMain {
        public static void main(String[] args) throws IOException {
            PaymentService paymentService = new WebApiPaymentService();
            Payment payment = paymentService.prepare(123L, "USD", BigDecimal.valueOf(1234.22));

            System.out.println(payment);
        }
}
