package com.example.bot.spring.amazon.search;

import com.example.bot.spring.amazon.model.ProductData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.example.bot.spring.amazon.product.ProductDataClient.*;
import static java.util.Collections.emptyList;

@Component
public class SearchClient {
    private static final Map<String, List<ProductData>> INDEX = ImmutableMap.of(
            "COKE", ImmutableList.of(COKE, COKE_ZERO),
            "TIDE", ImmutableList.of(TIDE, TIDE_GENTLE)
    );

    public List<ProductData> search(@NonNull String keyword) {
        return INDEX.getOrDefault(keyword.toUpperCase(), emptyList());
    }
}
