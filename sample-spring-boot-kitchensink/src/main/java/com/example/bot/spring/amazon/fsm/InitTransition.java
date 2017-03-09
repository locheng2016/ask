package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;
import org.statefulj.fsm.model.impl.StateActionPairImpl;

import java.util.Objects;

@Component
public class InitTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (Objects.equals(c.getLastInput(), "hello")) {
            return new StateActionPairImpl<>(BotState.HELLO, null);
        } else {
            return new StateActionPairImpl<>(BotState.INIT, null);
        }
    }
}
