package com.example.bot.spring.amazon.product;

import com.example.bot.spring.amazon.model.ProductData;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ProductDataClient {
    public static final ProductData COKE = ProductData.builder()
            .asin("B000T9WLTK")
            .title("Coca-Cola, 12 PK, 12 Fl oz Cans")
            .link("https://www.amazon.com/dp/B000T9WLTK")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/81CcM4UARkL._SX522_.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51+30WRU3mL._AC_US320_FMwebp_QL65_.jpg")
            .build();

    public static final ProductData COKE_ZERO = ProductData.builder()
            .asin("B00HZYE51Y")
            .title("Coca-Cola Zero, 12 PK, 12 Fl oz Cans")
            .link("https://www.amazon.com/dp/B00HZYE51Y")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/51lWQIH2PtL.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51lWQIH2PtL._AC_US320_QL65_.jpg")
            .build();

    public static final ProductData TIDE = ProductData.builder()
            .asin("B01BUNHFQM")
            .title("Tide PODS Spring Meadow")
            .link("https://www.amazon.com/dp/B01BUNHFQM")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/81cFI3BUZmL._SX522_.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51HlZv6MyRL._AC_US320_QL65_.jpg")
            .build();

    public static final ProductData TIDE_GENTLE = ProductData.builder()
            .asin("B00VRAF7ZU")
            .title("Tide PODS Free & Gentle")
            .link("https://www.amazon.com/dp/B00VRAF7ZU")
            .imageUrl("https://images-na.ssl-images-amazon.com/images/I/81SKSvp%2B9yL._SL1500_.jpg")
            .previewImageUrl("https://images-na.ssl-images-amazon.com/images/I/51G+tCCtBzL._AC_US320_QL65_.jpg")
            .build();

    public static final Set<ProductData> dataset = ImmutableSet.of(
            COKE,
            COKE_ZERO,
            TIDE,
            TIDE_GENTLE
    );

    private static Map<String, ProductData> productDataByAsin = new HashMap<>();

    public ProductDataClient() {
        dataset.forEach(productData -> productDataByAsin.put(productData.getAsin(), productData));
    }

    public boolean validAsin(String asin) {
        return productDataByAsin.containsKey(asin);
    }

    public ProductData getProduct(String asin) {
        return productDataByAsin.get(asin);
    }

}
