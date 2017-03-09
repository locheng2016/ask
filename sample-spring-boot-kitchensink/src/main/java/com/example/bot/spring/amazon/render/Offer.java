package com.example.bot.spring.amazon.render;

import com.example.bot.spring.amazon.model.ProductData;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Offer {

    private List<ProductData> products;

    public Offer(List<ProductData> products) {
        this.products = products;
    }

    public CarouselTemplate generateTemplate(String keyword) {
        return new CarouselTemplate(
                products.stream().map(
                        product -> new CarouselColumn(
                                product.getPreviewImageUrl(),
                                product.getTitle(),
                                "        ",
                                Arrays.asList(
                                        new PostbackAction("BUY","Buy " + product.getAsin(),"Buy it!"),
                                        new URIAction( "MORE LIKE THIS", createSearchUrl(keyword)))))
                .collect(Collectors.toList()));
    }

    private String createSearchUrl(String url) {
        return "https://www.amazon.com/s/ref=nb_sb_noss?field-keywords=" + url;

    }

}
