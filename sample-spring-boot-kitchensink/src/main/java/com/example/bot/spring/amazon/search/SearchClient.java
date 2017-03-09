package com.example.bot.spring.amazon.search;

import com.example.bot.spring.amazon.model.Asin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

@Component
public class SearchClient {
    private static final Asin COKE = Asin.builder()
            .title("Coca-Cola, 12 PK, 12 Fl oz Cans")
            .link("https://www.amazon.com/dp/B000T9WLTK")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/81CcM4UARkL._SX522_.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51+30WRU3mL._AC_US320_FMwebp_QL65_.jpg")
            .build();

    private static final Asin COKE_ZERO = Asin.builder()
            .title("Coca-Cola Zero, 12 PK, 12 Fl oz Cans")
            .link("https://www.amazon.com/dp/B00HZYE51Y")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/51lWQIH2PtL.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51lWQIH2PtL._AC_US320_QL65_.jpg")
            .build();

    private static final Asin TIDE = Asin.builder()
            .title("Tide PODS Spring Meadow")
            .link("https://www.amazon.com/dp/B01BUNHFQM")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/81cFI3BUZmL._SX522_.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51HlZv6MyRL._AC_US320_QL65_.jpg")
            .build();

    private static final Asin TIDE_GENTLE = Asin.builder()
            .title("Tide PODS Free & Gentle")
            .link("https://www.amazon.com/dp/B00VRAF7ZU")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/81SKSvp%2B9yL._SL1500_.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51G+tCCtBzL._AC_US320_QL65_.jpg")
            .build();

    private static final Map<String, List<Asin>> INDEX = ImmutableMap.of(
            "COKE", ImmutableList.of(COKE, COKE_ZERO),
            "TIDE", ImmutableList.of(TIDE, TIDE_GENTLE)
    );

    public List<Asin> search(@NonNull String keyword) {
        return INDEX.getOrDefault(keyword.toUpperCase(), emptyList());
    }
}
