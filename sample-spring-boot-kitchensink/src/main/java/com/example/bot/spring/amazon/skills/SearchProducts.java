package com.example.bot.spring.amazon.skills;

import com.example.bot.spring.amazon.BotSkill;
import com.example.bot.spring.amazon.model.Asin;
import com.example.bot.spring.amazon.model.BotSkillRequest;
import com.example.bot.spring.amazon.model.BotSkillResponse;
import com.example.bot.spring.amazon.model.ResponseType;
import com.example.bot.spring.amazon.search.SearchClient;

import java.util.List;

public class SearchProducts implements BotSkill {

    private static final SearchClient searchClient = new SearchClient();
    private static final String PRODUCT_FOUND = "I found these:";
    private static final String PRODUCT_NOT_FOUND = "I found find any product you want.";

    public BotSkillResponse execute(BotSkillRequest request) {

        List<Asin> productList = searchClient.search(request.getRequestMessage());

        if (productList.isEmpty()) {
            return buildResponseProductNotFound();
        } else {
            return buildResponseWithProductList(productList);
        }
    }

    private BotSkillResponse buildResponseProductNotFound() {
        return BotSkillResponse.builder()
                .responseType(ResponseType.TEXT)
                .responseText(PRODUCT_NOT_FOUND)
                .build();
    }

    private BotSkillResponse buildResponseWithProductList(List<Asin> productList) {
        return BotSkillResponse.builder()
                .responseType(ResponseType.ASIN)
                .responseText(PRODUCT_FOUND)
                .productList(productList)
                .build();
    }
}
