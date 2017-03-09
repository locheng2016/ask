package com.example.bot.spring.amazon.render;

import com.example.bot.spring.amazon.model.Asin;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.CarouselColumn;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class OrderConfirmation {
    private Asin asin;

    public OrderConfirmation(Asin asin) {
        this.asin = asin;
    }

    public ButtonsTemplate generateTemplate(String keyword) {
        return new ButtonsTemplate(
                asin.getPreviewImageUrl(),
                "You've brought " + keyword,
                asin.getTitle(),
                Arrays.asList(
                        new MessageAction("ADD TO DASH","Add it to my dashboard!"),
                        new MessageAction("CANCEL ORDER", "Cancel my order."))
        );
    }
}
