package com.example.bot.spring.amazon.fsm;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotActionResponse;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.Action;

import static com.example.bot.spring.amazon.model.ResponseType.HI_AMAZON;

@Component
public class HelloAction implements Action<Conversation> {
    @Override
    public void execute(Conversation c, String event, Object... args) throws RetryException {
        c.addResponse(
                BotActionResponse.builder()
                        .responseType(HI_AMAZON).build()
        );
    }
}
