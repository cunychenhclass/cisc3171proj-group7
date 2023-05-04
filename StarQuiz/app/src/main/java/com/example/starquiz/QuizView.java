package com.example.starquiz;

public interface QuizView {
    void displayQuiz(Quiz quiz);

    void displayScore(int score, int totalQuestions);

    void displayQuizResult(int score, int totalQuestions);
}

