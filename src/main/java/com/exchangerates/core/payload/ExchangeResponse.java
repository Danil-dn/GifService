package com.exchangerates.core.payload;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeResponse {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, Double> rates;

    public ExchangeResponse() {
    }
    public ExchangeResponse(Map<String, Double> rates) {
        this.rates = rates;
    }
}
