package com.exchangerates.core.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GifObject {
    private String id;
    private ImageObject images;
    private String title;

}
