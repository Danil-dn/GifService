package com.exchangerates.core.services;

import com.exchangerates.core.clients.ExchangeClient;
import com.exchangerates.core.payload.ExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@Service
public class ExchangeService {
    @Value("${openexchangeratesToken}")
    private String token;

    @Value("${baseCurrencyName}")
    private String baseMoneyName;

    private ExchangeClient exchangeClient;

    public ExchangeService(ExchangeClient exchangeClient) {
        this.exchangeClient = exchangeClient;
    }

    public boolean isCourseBiggerThenYesterday(String requiredMoneyName){
        ExchangeResponse todayExchangeResponse = getTodayExchangeRate();
        ExchangeResponse yesterdayExchangeResponse = getYesterdayExchangeRate();
        double todayCourse = calculateCourseRelativeToBaseCurrency(todayExchangeResponse, requiredMoneyName.toUpperCase());
        double yesterdayCourse = calculateCourseRelativeToBaseCurrency(yesterdayExchangeResponse, requiredMoneyName.toUpperCase());
        return todayCourse > yesterdayCourse;
    }
    //Ниже реализация методов! Подсчет по Доллору, остальные валюты по подписке.
    private ExchangeResponse getTodayExchangeRate(){
        Calendar todayCalendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(todayCalendar.getTime());
        return exchangeClient.getCourse(today, token);
    }

    private ExchangeResponse getYesterdayExchangeRate(){
        Calendar yesterdayCalendar = Calendar.getInstance();
        yesterdayCalendar.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String yesterday = dateFormat.format(yesterdayCalendar.getTime());
        return exchangeClient.getCourse(yesterday, token);
    }

    private double calculateCourseRelativeToBaseCurrency(ExchangeResponse exchangeResponse, String requiredMoneyName) throws NullPointerException{
        Map<String, Double> rates = exchangeResponse.getRates();
        double dollarToBaseCurrencyCourse = rates.get(baseMoneyName);
        double dollarToRequiredCurrencyCourse = rates.get(requiredMoneyName);
        return dollarToBaseCurrencyCourse/dollarToRequiredCurrencyCourse;

    }
}
