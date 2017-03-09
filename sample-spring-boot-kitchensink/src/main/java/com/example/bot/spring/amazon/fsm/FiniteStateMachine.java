package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.FSM;
import org.statefulj.fsm.Persister;
import org.statefulj.persistence.memory.MemoryPersisterImpl;

import static com.example.bot.spring.amazon.fsm.StateConstant.ALL;
import static com.example.bot.spring.amazon.fsm.StateConstant.BUY;
import static com.example.bot.spring.amazon.fsm.StateConstant.HELLO;
import static com.example.bot.spring.amazon.fsm.StateConstant.INIT;
import static com.example.bot.spring.amazon.fsm.StateConstant.ORDER;

@Component
public class FiniteStateMachine {
    private static final String USER_INPUT_EVENT = "USER_INPUT";
    private static final Persister<Conversation> PERSISTER = new MemoryPersisterImpl<>(ALL, INIT);

    private FSM<Conversation> fsm;

    @Autowired
    public FiniteStateMachine(
            InitTransition initTransition,
            HelloTransition helloTransition,
            BuyTransition buyTransition) {
        INIT.addTransition(USER_INPUT_EVENT, initTransition);
        HELLO.addTransition(USER_INPUT_EVENT, helloTransition);
        BUY.addTransition(USER_INPUT_EVENT, buyTransition);
        ORDER.addTransition(USER_INPUT_EVENT, INIT); // deterministic
        fsm = new FSM<>("FSM", PERSISTER);
    }

    @SneakyThrows
    public void handleUserInput(@NonNull Conversation conversation) {
        fsm.onEvent(conversation, USER_INPUT_EVENT);
    }
}
