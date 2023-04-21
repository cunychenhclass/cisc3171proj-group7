package com.example.starquiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionAnswerActivity extends AppCompatActivity {

    private TextView timerTextView;
    private TextView scoreTextView;
    private TextView levelTextView;
    private TextView questionTextView;
    private TextView userGreeting;
    private Button[] answerButtons = new Button[4];

    private Button trueAnswer;
    private Button[] lifelineButtons = new Button[6];
    private int score;
    private int level;
    private long timer;
    private boolean recheckButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

        Bundle extras = getIntent().getExtras();

        recheckButtons = false;
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

        // Set up lifeline button click listeners - makes no sense to initialize button fuctions in a loop, would just replace every one
//        for (Button button : lifelineButtons) {
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // Implement lifeline functionality
//
//
//                }
//            });
//        }

        lifelineButtons[0].setOnClickListener(new View.OnClickListener() { //lifeline 1 remove 1
                @Override
                public void onClick(View view) {
                    for (Button button : answerButtons) {
                        if(button != trueAnswer)
                        {
                            button.setEnabled(false);
                            recheckButtons = true;
                            break;
                        }

                    }
                }
            });

        lifelineButtons[1].setOnClickListener(new View.OnClickListener() { //lifeline 2 skip question
            @Override
            public void onClick(View view) {
                // skip question in database
            }
        });

        lifelineButtons[2].setOnClickListener(new View.OnClickListener() { //lifeline 3 restore timer
            @Override
            public void onClick(View view) {
                timer *= 1.50;
            }
        });

        lifelineButtons[3].setOnClickListener(new View.OnClickListener() { //lifeline 4 50/50
            @Override
            public void onClick(View view) {
                int l = 0;
                do {
                    Random rand = new Random();
                    int n = rand.nextInt(3);
                    if(answerButtons[n] != trueAnswer)
                    {
                        answerButtons[n].setEnabled(false);
                        recheckButtons = true;
                        l++;
                    }
                }
                while(l != 2);

            }
        });

        lifelineButtons[4].setOnClickListener(new View.OnClickListener() { //lifeline 5 double dip
            @Override
            public void onClick(View view) {

            }
        });

        lifelineButtons[5].setOnClickListener(new View.OnClickListener() { //lifeline 6
            @Override
            public void onClick(View view) {

            }
        });

        // Start a sample timer
        startTimer(10000);
    }

    public void recheckAllButtons() //make sure to run this after choice is made/before next question is pulled
    {
        for (Button button: answerButtons
             ) {
            if(!button.isEnabled())
            {
                button.setEnabled(true);
            }
        }
    }
    private void displayQuestion(String questionText, String[] answers) {
        questionTextView.setText(questionText);
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answers[i]);
        }
        Random rand = new Random();
        trueAnswer = answerButtons[rand.nextInt(3)];
    }

    private void startTimer(long timeMillis) {
        new CountDownTimer(timeMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.format("%.1f", millisUntilFinished / 1000.0));
                timer = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                // Handle timer expiration
            }
        }.start();
    }
}