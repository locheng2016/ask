package com.example.bot.spring.amazon.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ProductData {
    private String asin;
    private String title;
    private String link;
    private String imageUrl;
    private String previewImageUrl;
}
