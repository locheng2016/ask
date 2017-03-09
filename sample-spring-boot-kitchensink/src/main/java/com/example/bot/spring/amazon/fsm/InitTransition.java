package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;
import org.statefulj.fsm.model.impl.StateActionPairImpl;

import java.util.Objects;

public class InitTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (Objects.equals(c.getLastInput(), "hello")) {
            System.out.println("You said hello, go to HELLO state");
            return new StateActionPairImpl<>(BotState.HELLO, null);
        } else {
            System.out.println("Cannot understand, staying in INIT");
            return new StateActionPairImpl<>(BotState.INIT, null);
        }
    }
}
