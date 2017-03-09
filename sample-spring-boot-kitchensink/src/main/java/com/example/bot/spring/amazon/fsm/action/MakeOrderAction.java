package com.example.bot.spring.amazon.fsm.action;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotActionResponse;
import com.example.bot.spring.amazon.model.ResponseType;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.Action;

public class MakeOrderAction implements Action<Conversation> {

    private String responseString = "Just made an order for your product.";

    public void execute(Conversation c, String event, Object ... args) throws RetryException {

        BotActionResponse response = BotActionResponse.builder()
                .responseType(ResponseType.TEXT)
                .responseText(responseString)
                .build();

        c.addResponse(response);
    }
}
