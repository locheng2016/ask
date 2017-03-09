package com.example.bot.spring.amazon.skills;

import com.example.bot.spring.amazon.model.BotSkillRequest;
import com.example.bot.spring.amazon.model.BotSkillResponse;
import com.example.bot.spring.amazon.model.ResponseType;

public class Chat {

    public BotSkillResponse execute(BotSkillRequest request) {

        return BotSkillResponse.builder()
                .responseType(ResponseType.DEFAULT)
                .build();
    }
}
