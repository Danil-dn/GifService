package com.exchangerates.core.controllers;

import com.exchangerates.core.services.ExchangeService;
import com.exchangerates.core.services.GifService;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private final ExchangeService exchangeService;
    private final GifService gifService;

    public ExchangeController(ExchangeService exchangeService, GifService gifService) {
        this.exchangeService = exchangeService;
        this.gifService = gifService;
    }
    //http://localhost:8080/exchangerates?money_name=USD возможный пример
    @SneakyThrows
    @GetMapping("/exchangerates")
    public ResponseEntity<byte[]> GetRates(@RequestParam(name = "money_name") String moneyName) {

        boolean isCourseBigger = exchangeService.isCourseBiggerThenYesterday(moneyName);
        byte[] gifBytes = gifService.getRandomGif(isCourseBigger);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
                .body(gifBytes);
    }
}