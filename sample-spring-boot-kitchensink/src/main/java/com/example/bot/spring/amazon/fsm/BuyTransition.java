package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotSkillRequest;
import com.example.bot.spring.amazon.model.BotSkillResponse;
import com.example.bot.spring.amazon.skills.MakeOrder;
import com.example.bot.spring.amazon.skills.SearchProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

@Component
public class BuyTransition implements Transition<Conversation> {

    private SearchProducts searchProducts = new SearchProducts();
    private MakeOrder makeOrder = new MakeOrder();

    @Autowired
    @Qualifier("goToOrder")
    private StateActionPair<Conversation> goToOrder;

    @Autowired
    @Qualifier("goToBuy")
    private StateActionPair<Conversation> goToBuy;

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {

        // generate request based on user input
        BotSkillRequest request = BotSkillRequest.builder()
                .requestMessage(c.getLastInput())
                .build();

        BotSkillResponse response = null;

        if (isAsin(c.getLastInput())) {
            response = makeOrder.execute(request);
            c.addResponse(response);

            return goToOrder;
        } else {

            // call search product skill to get list of ASINs
            response = searchProducts.execute(request);
            c.addResponse(response);

            return goToBuy;
        }
    }

    private boolean isAsin(String input) {
        return input.startsWith("Buy:");
    }
}
