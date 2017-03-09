package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import lombok.SneakyThrows;
import org.statefulj.fsm.FSM;
import org.statefulj.fsm.Persister;
import org.statefulj.persistence.memory.MemoryPersisterImpl;

import java.util.Scanner;

public class FiniteStateMachine {
    @SneakyThrows
    public static void run() {
        BotState.INIT.addTransition("userInput", new InitTransition());
        BotState.HELLO.addTransition("userInput", new BuyTransition());
        BotState.BUY.addTransition("userInput", new BuyTransition());

        Persister<Conversation> persister = new MemoryPersisterImpl<>(BotState.ALL, BotState.INIT);
        FSM<Conversation> fsm = new FSM<>("FSM", persister);

        Conversation conversation = new Conversation();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            conversation.addInput(scanner.nextLine());
            fsm.onEvent(conversation, "userInput");
        }
    }
}
