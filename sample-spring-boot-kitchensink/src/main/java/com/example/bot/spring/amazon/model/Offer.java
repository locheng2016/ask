package com.example.bot.spring.amazon.model;

import com.example.bot.spring.amazon.model.Asin;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.template.CarouselColumn;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by locheng on 3/9/17.
 *
 */
@Slf4j
public class Offer {

    private List<Asin> asins;

    public Offer(List<Asin> asins) {
        this.asins = asins;
    }

    public List<CarouselColumn> generateCarouselTemplate(String keyword) {
        return asins.stream().map(
                asin -> new CarouselColumn(
                        asin.getPreviewImageUrl(),
                        asin.getTitle(),
                        "        ",
                        Arrays.asList(
                                new URIAction("BUY", asin.getLink()),
                                new URIAction( "MORE LIKE THIS", createSearchUrl(keyword)))))
                .collect(Collectors.toList());
    }

    private String createSearchUrl(String url) {
        return "https://www.amazon.com/s/ref=nb_sb_noss?field-keywords=" + url;

    }

}
