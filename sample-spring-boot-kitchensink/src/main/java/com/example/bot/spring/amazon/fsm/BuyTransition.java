package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.google.common.collect.ImmutableSet;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_BUY;
import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_ORDER;

@Component
public class BuyTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (isAsin(c.getLastInput())) {
            return GO_TO_ORDER;
        } else {
            return GO_TO_BUY;
        }
    }

    private boolean isAsin(String input) {
        return ImmutableSet.of("asin1", "asin2", "asin3").contains(input);
    }
}
