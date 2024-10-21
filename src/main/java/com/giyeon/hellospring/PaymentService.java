package com.giyeon.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PaymentService {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        //환율 가져오기
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        //연결 설정
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        //요청 보내고 응답 받아오기
        InputStream inputStream = httpURLConnection.getInputStream();
        //바이트 스트림을 문자열로 변경하고 이를 버퍼에 담음
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        //버퍼에 있는 문자열을 한줄씩 꺼내서 하나의 String으로 합침
        String collect = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        //가져온 Json String을 ExRateData에 Mapper를 사용해서 자동으로 집어 넣는다
        ExRateData exRateData = mapper.readValue(collect, ExRateData.class);

        //외국통화와 원의 환율
        BigDecimal exRate = exRateData.rates().get("KRW");

        //한국돈으로 얼마인지 계산
        BigDecimal koreanWonPrice = foreignCurrencyAmount.multiply(exRate);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, koreanWonPrice, LocalDateTime.now().plusMinutes(30));
    }

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(123L, "USD", BigDecimal.valueOf(1234.22));

        System.out.println(payment);
    }
}
