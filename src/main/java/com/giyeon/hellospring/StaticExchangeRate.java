package com.giyeon.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class StaticExchangeRate implements ExchangeRate {
    @Override
    public BigDecimal getExchangeRate(String currency) {
        return BigDecimal.valueOf(1000);
    }
}
