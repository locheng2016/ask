package com.example.bot.spring.amazon.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Asin {
    private String title;
    private String link;
    private String imageUrl;
    private String previewImageUrl;
}
