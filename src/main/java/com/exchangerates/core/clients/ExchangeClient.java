package com.exchangerates.core.clients;

import com.exchangerates.core.payload.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "exchange", url = "${openexchangeratesUrl}")
public interface ExchangeClient {
    @RequestMapping(value = "/historical/{date}.json", method = RequestMethod.GET, params = {"app_id"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    ExchangeResponse getCourse(@PathVariable String date, @RequestParam(value = "app_id") String appId);
}
