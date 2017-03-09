package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import java.util.Objects;

@Component
public class InitTransition implements Transition<Conversation> {
    @Autowired
    @Qualifier("goToHello")
    private StateActionPair<Conversation> goToHello;

    @Autowired
    @Qualifier("goToInit")
    private StateActionPair<Conversation> goToInit;

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        if (c.getLastInput().getText().equals("hello")) {
            return goToHello;
        } else {
            return goToInit;
        }
    }
}
