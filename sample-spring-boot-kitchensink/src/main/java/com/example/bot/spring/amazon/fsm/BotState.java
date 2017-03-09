package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.google.common.collect.ImmutableList;
import org.statefulj.fsm.model.State;
import org.statefulj.fsm.model.StateActionPair;
import org.statefulj.fsm.model.impl.StateActionPairImpl;
import org.statefulj.fsm.model.impl.StateImpl;

import java.util.List;

class BotState {
    static final State<Conversation> INIT = new StateImpl<>("INIT");
    static final State<Conversation> HELLO = new StateImpl<>("HELLO");
    static final State<Conversation> BUY = new StateImpl<>("BUY");
    static final State<Conversation> ORDER = new StateImpl<>("ORDER");

    static final List<State<Conversation>> ALL = ImmutableList.of(INIT, HELLO, BUY, ORDER);

    static final StateActionPair<Conversation> GO_TO_INIT = new StateActionPairImpl<>(INIT, null);
    static final StateActionPair<Conversation> GO_TO_HELLO = new StateActionPairImpl<>(HELLO, null);
    static final StateActionPair<Conversation> GO_TO_BUY = new StateActionPairImpl<>(BUY, null);
    static final StateActionPair<Conversation> GO_TO_ORDER = new StateActionPairImpl<>(ORDER, null);
}
