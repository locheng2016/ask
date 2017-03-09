package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotActionResponse;
import com.example.bot.spring.amazon.model.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

@Component
public class HelloTransition implements Transition<Conversation> {
    @Autowired
    @Qualifier("goToHello")
    private StateActionPair<Conversation> goToHello;

    @Autowired
    @Qualifier("goToBuy")
    private StateActionPair<Conversation> goToBuy;

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (c.getLastInput().getText().equals("I want to buy")) {
            c.addResponse(BotActionResponse.builder()
                    .responseText("What do you want to buy?")
                    .responseType(ResponseType.TEXT)
                    .build());
            return goToBuy;
        } else {
            return goToHello;
        }
    }
}
