package com.example.bot.spring.amazon.dao;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

import static com.example.bot.spring.amazon.Constant.CUSTOMER_ID;

@Component
public class AsinHistoryDao extends HashMap<String, List<String>> {
    public String getLastAsin() {
        return getLastAsin(CUSTOMER_ID);
    }

    private String getLastAsin(@NonNull String customerId) {
        List<String> asins = get(customerId);
        return asins.get(asins.size() - 1);
    }
}
