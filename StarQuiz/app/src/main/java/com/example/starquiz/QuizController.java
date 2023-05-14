package com.example.starquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizController {
    private QuizView quizView;
    private List<Quiz> quizList = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;

    public QuizController(QuizView quizView) {
        this.quizView = quizView;

        // Initialize the quiz list
        quizList.add(new Quiz("What is the capital of France?",
                Arrays.asList("Paris", "Rome", "Madrid"), 0));
        quizList.add(new Quiz("Who is the current president of the United States?",
                Arrays.asList("Barack Obama", "Joe Biden", "Donald Trump"), 1));
        quizList.add(new Quiz("What is the largest continent in the world?",
                Arrays.asList("Africa", "Asia", "North America"), 1));
    }

    public void startQuiz() {
        Quiz currentQuiz = quizList.get(currentQuestionIndex);
        quizView.displayQuiz(currentQuiz);
    }

    public void selectAnswer(int answerIndex) {
        if (answerIndex == quizList.get(currentQuestionIndex).getAnswerIndex()) {
            score++;
        }
        currentQuestionIndex++;

        if (currentQuestionIndex < quizList.size()) {
            Quiz currentQuiz = quizList.get(currentQuestionIndex);
            quizView.displayQuiz(currentQuiz);
        } else {
            quizView.displayQuizResult(score, quizList.size());
        }
    }

    public void showScore() {
        quizView.displayScore(score, quizList.size());
    }
}


