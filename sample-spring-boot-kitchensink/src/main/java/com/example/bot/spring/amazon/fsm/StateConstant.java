package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.google.common.collect.ImmutableList;
import org.statefulj.fsm.model.State;
import org.statefulj.fsm.model.impl.StateImpl;

import java.util.List;

class StateConstant {
    static final State<Conversation> INIT = new StateImpl<>("INIT");
    static final State<Conversation> HELLO = new StateImpl<>("HELLO");
    static final State<Conversation> BUY = new StateImpl<>("BUY");
    static final State<Conversation> ORDER = new StateImpl<>("ORDER");

    static final List<State<Conversation>> ALL = ImmutableList.of(INIT, HELLO, BUY, ORDER);
}
