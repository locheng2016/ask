package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.fsm.action.MakeOrderAction;
import com.example.bot.spring.amazon.fsm.action.SearchProductAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

@Component
public class BuyTransition implements Transition<Conversation> {

    private SearchProductAction searchProductAction = new SearchProductAction();
    private MakeOrderAction makeOrder = new MakeOrderAction();

    @Autowired
    @Qualifier("goToOrder")
    private StateActionPair<Conversation> goToOrder;

    @Autowired
    @Qualifier("goToBuy")
    private StateActionPair<Conversation> goToBuy;

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args)
            throws RetryException {
        if (isAsin(c.getLastInput())) {
            return goToOrder;
        } else {
            return goToBuy;
        }
    }

    private boolean isAsin(String input) {
        return input.startsWith("Buy:");
    }
}
