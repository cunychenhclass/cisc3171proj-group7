package com.example.starquiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionAnswerActivity extends AppCompatActivity {

    private TextView timerTextView;
    private TextView scoreTextView;
    private TextView levelTextView;
    private TextView questionTextView;
    private TextView userGreeting;
    private Button[] answerButtons = new Button[4];
    private Button[] lifelineButtons = new Button[6];
    private int score;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

        Bundle extras = getIntent().getExtras();

        // Initialize views by ID
        timerTextView = findViewById(R.id.timer);
        scoreTextView = findViewById(R.id.score);
        levelTextView = findViewById(R.id.level);
        questionTextView = findViewById(R.id.question);
        userGreeting = findViewById(R.id.questionAnswerUserGreeting);

        userGreeting.setText("Hello " + extras.getString("username"));


        for (int i = 0; i < 4; i++) {
            int buttonId = getResources().getIdentifier("answer" + (i + 1), "id", getPackageName());
            answerButtons[i] = findViewById(buttonId);
        }
        for (int i = 0; i < 6; i++) {
            int buttonId = getResources().getIdentifier("lifeline" + (i + 1), "id", getPackageName());
            lifelineButtons[i] = findViewById(buttonId);
        }

        // Initialize score and level
        score = 0;
        level = 1;

        // Set up a sample question and answers
        displayQuestion("Sample question", new String[]{"Answer 1", "Answer 2", "Answer 3", "Answer 4"});

        // Set up answer button click listeners
        for (Button button : answerButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle answer selection and move to next question or end the quiz
                }
            });
        }

        // Set up lifeline button click listeners
        for (Button button : lifelineButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Implement lifeline functionality
                }
            });
        }

        // Start a sample timer
        startTimer(10000);
    }

    private void displayQuestion(String questionText, String[] answers) {
        questionTextView.setText(questionText);
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answers[i]);
        }
    }

    private void startTimer(long timeMillis) {
        new CountDownTimer(timeMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.format("%.1f", millisUntilFinished / 1000.0));
            }

            @Override
            public void onFinish() {
                // Handle timer expiration
            }
        }.start();
    }
}