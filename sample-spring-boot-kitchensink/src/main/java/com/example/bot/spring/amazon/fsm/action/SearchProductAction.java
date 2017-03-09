package com.example.bot.spring.amazon.fsm.action;

import com.example.bot.spring.amazon.bot.Conversation;
import com.example.bot.spring.amazon.model.BotActionResponse;
import com.example.bot.spring.amazon.model.ProductData;
import com.example.bot.spring.amazon.model.ResponseType;
import com.example.bot.spring.amazon.search.SearchClient;
import org.springframework.stereotype.Component;
import org.statefulj.fsm.RetryException;
import org.statefulj.fsm.model.Action;

import java.util.List;

@Component
public class SearchProductAction implements Action<Conversation> {

    private static final SearchClient searchClient = new SearchClient();
    private static final String PRODUCT_FOUND = "I found these:";
    private static final String PRODUCT_NOT_FOUND = "I found find any product you want.";

    public void execute(Conversation c, String event, Object ... args) throws RetryException {

        final String userMessage = c.getLastInput();

        List<ProductData> productList = searchClient.search(userMessage);

        BotActionResponse response = null;

        if (productList.isEmpty()) {
            response = buildResponseProductNotFound();
        } else {
            response = buildResponseWithProductList(productList);
        }

        c.addResponse(response);
    }

    private BotActionResponse buildResponseProductNotFound() {
        return BotActionResponse.builder()
                .responseType(ResponseType.TEXT)
                .responseText(PRODUCT_NOT_FOUND)
                .build();
    }

    private BotActionResponse buildResponseWithProductList(List<ProductData> productList) {
        return BotActionResponse.builder()
                .responseType(ResponseType.ASIN)
                .responseText(PRODUCT_FOUND)
                .productList(productList)
                .build();
    }
}
