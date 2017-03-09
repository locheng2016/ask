package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.google.common.collect.ImmutableSet;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;
import org.statefulj.fsm.model.impl.StateActionPairImpl;

public class BuyTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (isAsin(c.getLastInput())) {
            return new StateActionPairImpl<>(BotState.ORDER, null);
        } else {
            return new StateActionPairImpl<>(BotState.BUY, null);
        }
    }

    private boolean isAsin(String input) {
        return ImmutableSet.of("asin1", "asin2", "asin3").contains(input);
    }
}
