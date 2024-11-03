package com.giyeon.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.math.BigDecimal;

public class PaymentServiceMain {

        public static void main(String[] args) throws IOException {
            BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);

            PaymentService paymentService = beanFactory.getBean(PaymentService.class);
            Payment payment = paymentService.prepare(123L, "USD", BigDecimal.valueOf(1234.22));
            System.out.println(payment);

        }

}
