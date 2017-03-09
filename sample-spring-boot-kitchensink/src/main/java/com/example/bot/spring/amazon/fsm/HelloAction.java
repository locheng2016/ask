package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.Action;

@Component
public class HelloAction implements Action<Conversation> {
    @Override
    public void execute(Conversation c, String event, Object... args) throws RetryException {
        // generate hello window based on
    }
}
