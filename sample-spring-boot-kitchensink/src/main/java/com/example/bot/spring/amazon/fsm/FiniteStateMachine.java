package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.FSM;
import org.statefulj.persistence.memory.MemoryPersisterImpl;

@Component
public class FiniteStateMachine {
    private FSM<Conversation> fsm;

    @Autowired
    public FiniteStateMachine(
            InitTransition initTransition,
            HelloTransition helloTransition,
            BuyTransition buyTransition) {
        BotState.INIT.addTransition("userInput", initTransition);
        BotState.HELLO.addTransition("userInput", helloTransition);
        BotState.BUY.addTransition("userInput", buyTransition);
        fsm = new FSM<>("FSM", new MemoryPersisterImpl<>(BotState.ALL, BotState.INIT));
    }

    @SneakyThrows
    public void handleUserInput(@NonNull Conversation conversation) {
        fsm.onEvent(conversation, "USER_INPUT");
    }
}
