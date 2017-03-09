package com.example.bot.spring.amazon.fsm.action;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotActionResponse;
import com.example.bot.spring.amazon.model.ResponseType;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.Action;

public class ChatAction implements Action<Conversation> {

    public void execute(Conversation c, String event, Object ... args) throws RetryException {

        BotActionResponse response = BotActionResponse.builder()
                .responseType(ResponseType.DEFAULT)
                .build();

        c.addResponse(response);
    }
}
