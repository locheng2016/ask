package com.example.bot.spring.amazon.render;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.Template;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;

public class HiAmazon {
    public Template generateTemplate() {
        String imageUrl = createUri("/static/buttons/1024.jpg");
        return new ButtonsTemplate(
                imageUrl,
                "Hi Amazon",
                "What can I help you with?",
                Arrays.asList(
                        new MessageAction("Want to buy?",
                                "buy"),
                        new MessageAction("My Dash Buttons",
                                "my dash"),
                        new MessageAction("My Orders",
                                "my orders"),
                        new MessageAction("What is Prime?",
                                "prime")
                ));
    }

    private static String createUri(String path) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(path).build()
                .toUriString();
    }


}
