package com.example.bot.spring.amazon.bot;

import com.example.bot.spring.amazon.model.BotActionResponse;
import lombok.Data;
import lombok.NonNull;
import org.statefulj.persistence.annotations.State;

import java.util.ArrayList;
import java.util.List;

@Data
public class Conversation {
    @State
    private String state;
    private List<String> history = new ArrayList<>();
    private List<BotActionResponse> responseHistory = new ArrayList<>();

    public void addInput(@NonNull String input) {
        history.add(input);
    }

    public void addResponse(@NonNull BotActionResponse response) {
        responseHistory.add(response);
    }

    public String getLastInput() {
        return history.get(history.size() - 1);
    }

    public BotActionResponse getLastResponse() {
        return responseHistory.get(responseHistory.size() - 1);
    }
}
