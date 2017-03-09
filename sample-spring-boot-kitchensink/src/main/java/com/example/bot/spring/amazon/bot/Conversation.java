package com.example.bot.spring.amazon.bot;

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

    public void addInput(@NonNull String input) {
        history.add(input);
    }

    public String getLastInput() {
        return history.get(history.size() - 1);
    }
}
