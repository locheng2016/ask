package com.example.bot.spring.amazon.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class BotSkillResponse {
    private ResponseType responseType;
    private String responseText;
    private String customerKeyword;
    private List<ProductData> productList;
}
