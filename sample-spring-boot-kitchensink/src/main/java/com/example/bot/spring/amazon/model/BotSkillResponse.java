package com.example.bot.spring.amazon.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BotSkillResponse {
    private boolean doTransition;
    private String targetState;
    private String responseString;
}
