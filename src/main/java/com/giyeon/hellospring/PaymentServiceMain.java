package com.giyeon.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class PaymentServiceMain {

        public static void main(String[] args) throws IOException, InterruptedException {
//            BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
//
//            PaymentService paymentService = beanFactory.getBean(PaymentService.class);
//            Payment payment = paymentService.prepare(123L, "USD", BigDecimal.valueOf(1234.22));
//            System.out.println(payment);

            BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
            PaymentService paymentService1 = beanFactory.getBean(PaymentService.class);
            Payment payment1 = paymentService1.prepare(123L, "USD", BigDecimal.valueOf(1234.22));
            System.out.println(payment1);
            TimeUnit.SECONDS.sleep(1);

            PaymentService paymentService2 = beanFactory.getBean(PaymentService.class);
            Payment payment2 = paymentService2.prepare(123L, "USD", BigDecimal.valueOf(1234.22));
            System.out.println(payment2);

        }

}
