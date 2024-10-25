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

abstract public class PaymentService {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = getKRWExchangeRate(currency);
        BigDecimal koreanWonPrice = foreignCurrencyAmount.multiply(exRate);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, koreanWonPrice, LocalDateTime.now().plusMinutes(30));
    }

    abstract public BigDecimal getKRWExchangeRate(String currency) throws IOException;

    abstract public BigDecimal getVipExchangeRate(String currency) throws IOException;

}
