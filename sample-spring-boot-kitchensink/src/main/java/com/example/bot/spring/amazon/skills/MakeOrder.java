package com.example.bot.spring.amazon.skills;

import com.example.bot.spring.amazon.model.BotSkillRequest;
import com.example.bot.spring.amazon.model.BotSkillResponse;
import com.example.bot.spring.amazon.model.ResponseType;

public class MakeOrder {

    private String responseString = "Just made an order for your product.";

    public BotSkillResponse execute(BotSkillRequest request) {

        // find the asin
        // return the result
        return BotSkillResponse.builder()
                .responseType(ResponseType.TEXT)
                .responseText(responseString)
                .build();
    }
}
