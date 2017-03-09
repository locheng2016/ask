package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.dao.AsinHistoryDao;
import com.example.bot.spring.amazon.dao.DashDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import java.util.Objects;

@Component
public class OrderTransition implements Transition<Conversation> {
    @Autowired
    private AsinHistoryDao asinHistoryDao;

    @Autowired
    private DashDao dashDao;

    @Autowired
    @Qualifier("goToHello")
    private StateActionPair<Conversation> goToHello;

    @Autowired
    @Qualifier("goToBuy")
    private StateActionPair<Conversation> goToBuy;

    @Autowired
    @Qualifier("goToInit")
    private StateActionPair<Conversation> goToInit;

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {
        String input = c.getLastInput().getText();
        if (Objects.equals(input, "add to dash")) {
            addLastAsinToDash();
            return goToHello;
        } else if (Objects.equals(input, "buy something else")) {
            return goToBuy;
        } else {
            return goToInit;
        }
    }

    private void addLastAsinToDash() {
        String asin = asinHistoryDao.getLastAsin();
        dashDao.add(asin);
    }
}
