package com.example.bot.spring.amazon.dao;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.bot.spring.amazon.Constant.CUSTOMER_ID;

@Component
public class DashDao extends HashMap<String, List<String>> {
    public void add(@NonNull String asin) {
        add(CUSTOMER_ID, asin);
    }

    private void add(@NonNull String customerId, String asin) {
        getOrDefault(customerId, new ArrayList<>()).add(asin);
    }
}
