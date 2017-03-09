package com.example.bot.spring.amazon.render;

import com.example.bot.spring.amazon.model.ProductData;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class OrderConfirmation {
    private ProductData asin;

    public OrderConfirmation(ProductData asin) {
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
