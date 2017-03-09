package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.impl.StateActionPairImpl;

import static com.example.bot.spring.amazon.fsm.StateConstant.BUY;
import static com.example.bot.spring.amazon.fsm.StateConstant.HELLO;
import static com.example.bot.spring.amazon.fsm.StateConstant.INIT;
import static com.example.bot.spring.amazon.fsm.StateConstant.ORDER;

@Configuration
public class StateContext {
    @Bean("goToInit")
    public StateActionPair<Conversation> goToInit() {
        return new StateActionPairImpl<>(INIT, null);
    }

    @Bean("goToHello")
    public StateActionPair<Conversation> goToHello(HelloAction helloAction) {
        return new StateActionPairImpl<>(HELLO, helloAction);
    }

    @Bean("goToBuy")
    public StateActionPair<Conversation> goToBuy() {
        return new StateActionPairImpl<>(BUY, null);
    }

    @Bean("goToOrder")
    public StateActionPair<Conversation> goToOrder() {
        return new StateActionPairImpl<>(ORDER, null);
    }
}
