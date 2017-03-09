package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;
import org.statefulj.fsm.model.impl.StateActionPairImpl;

import java.util.Objects;

public class HelloTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (Objects.equals(c.getLastInput(), "I want to buy")) {
            System.out.println("You said you want to buy, go to BUY state");
            return new StateActionPairImpl<>(BotState.BUY, null);
        } else {
            System.out.println("Cannot understand, staying in HELLO state");
            return new StateActionPairImpl<>(BotState.HELLO, null);
        }
    }
}
