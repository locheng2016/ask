package com.example.bot.spring.amazon.render;

import com.example.bot.spring.amazon.model.BotActionResponse;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RenderClient {
    public Message renderMessage(BotActionResponse response) {
        String customerKeyword = response.getCustomerKeyword();
        switch (response.getResponseType()) {
            case TEXT: {
                return new TextMessage(response.getResponseText());
            }
            case OFFER: {
                return new TemplateMessage("Carousel alt text",
                        new Offer(response.getProductList()).generateTemplate(customerKeyword));
            }
            case ORDER_CONFIRMATION: {
                return new TemplateMessage("Button alt text",
                        new OrderConfirmation(response.getProductList().get(0)).generateTemplate(response.getCustomerKeyword()));
            }
            case HI_AMAZON: {
                return new TemplateMessage("Hi Amazon!",
                        new HiAmazon().generateTemplate());

            }
        }
        return null; //TODO: defulat Template
    }

}
