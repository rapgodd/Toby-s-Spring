package com.giyeon.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebApiExchangeRate implements ExchangeRate{

    @Override
    public BigDecimal getExchangeRate(String currency) throws IOException {
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
        return exRate;
    }
}
