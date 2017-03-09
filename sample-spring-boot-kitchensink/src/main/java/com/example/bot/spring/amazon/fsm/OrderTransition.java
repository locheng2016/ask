package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.dao.AsinHistoryDao;
import com.example.bot.spring.amazon.dao.DashDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import java.util.Objects;

import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_BUY;
import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_HELLO;
import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_INIT;

@Component
public class OrderTransition implements Transition<Conversation> {
    @Autowired
    private AsinHistoryDao asinHistoryDao;

    @Autowired
    private DashDao dashDao;

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        String input = c.getLastInput();
        if (Objects.equals(input, "add to dash")) {
            addLastAsinToDash();
            return GO_TO_HELLO;
        } else if (Objects.equals(input, "buy something else")) {
            return GO_TO_BUY;
        } else {
            return GO_TO_INIT;
        }
    }

    private void addLastAsinToDash() {
        String asin = asinHistoryDao.getLastAsin();
        dashDao.add(asin);
    }
}
