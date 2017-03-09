package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotSkillRequest;
import com.example.bot.spring.amazon.model.BotSkillResponse;
import com.example.bot.spring.amazon.skills.MakeOrder;
import com.example.bot.spring.amazon.skills.SearchProducts;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.Transition;

import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_BUY;
import static com.example.bot.spring.amazon.fsm.StateConstant.GO_TO_ORDER;

@Component
public class BuyTransition implements Transition<Conversation> {

    private SearchProducts searchProducts = new SearchProducts();
    private MakeOrder makeOrder = new MakeOrder();

    @Override
    public StateActionPair<Conversation> getStateActionPair(Conversation c, String event, Object... args) throws RetryException {

        // generate request based on user input
        BotSkillRequest request = BotSkillRequest.builder()
                .requestMessage(c.getLastInput())
                .build();

        BotSkillResponse response = null;

        if (isAsin(c.getLastInput())) {
            response = makeOrder.execute(request);

            // TODO: save the response some where for render user message

            return GO_TO_ORDER;
        } else {

            // call search product skill to get list of ASINs
            response = searchProducts.execute(request);

            // TODO: save the response some where for render user message

            return GO_TO_BUY;
        }
    }

    private boolean isAsin(String input) {
        return input.startsWith("Buy:");
    }
}
