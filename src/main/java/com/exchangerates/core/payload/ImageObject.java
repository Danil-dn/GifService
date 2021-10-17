package com.exchangerates.core.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ImageObject {
    private Map<String, String> original;
    private Map<String,String> downsized;
}