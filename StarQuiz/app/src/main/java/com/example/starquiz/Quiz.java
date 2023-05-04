package com.example.starquiz;

import java.util.List;

public class Quiz {
    private String question;
    private List<String> options;
    private int answerIndex;

    public Quiz(String question, List<String> options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}


