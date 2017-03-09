package com.example.bot.spring.amazon.bot;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BotInput {
    private InputType type;
    private String asin;
    private String text;

    public static enum InputType {
        BUY, TEXT
    }
}
