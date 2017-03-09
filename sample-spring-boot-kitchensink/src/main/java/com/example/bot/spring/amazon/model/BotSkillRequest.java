package com.example.bot.spring.amazon.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BotSkillRequest {
    private String currentState;
    private String requestMessage;
}
