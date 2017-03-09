package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import java.util.Objects;

import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_BUY;
import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_HELLO;

@Component
public class HelloTransition implements Transition<Conversation> {
    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (Objects.equals(c.getLastInput(), "I want to buy")) {
            return GO_TO_BUY;
        } else {
            return GO_TO_HELLO;
        }
    }
}
