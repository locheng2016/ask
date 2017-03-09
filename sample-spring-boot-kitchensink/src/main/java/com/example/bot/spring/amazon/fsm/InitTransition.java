package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import java.util.Objects;

import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_HELLO;
import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_INIT;

@Component
public class InitTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (Objects.equals(c.getLastInput(), "hello")) {
            return GO_TO_HELLO;
        } else {
            return GO_TO_INIT;
        }
    }
}
