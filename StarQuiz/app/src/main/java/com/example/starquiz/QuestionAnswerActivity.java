package com.example.starquiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionAnswerActivity extends AppCompatActivity {

    private QuizController quizControl;
    private TextView timerTextView;
    private TextView graceTimerTextView;
    private TextView scoreTextView;
    private TextView levelTextView;
    private TextView questionTextView;
    private TextView userGreeting;
    private Button[] answerButtons = new Button[4];

    private Button trueAnswer;
    private Button[] lifelineButtons = new Button[6];
    private int score;
    private int level;
    private boolean recheckButtons;
    private boolean picking2 = false;
    private boolean secondChancing = false;
    private Button[] picking2Buttons = new Button[2];
    private int buttonsPressed = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

        Bundle extras = getIntent().getExtras();
        recheckButtons = false;
        buttonsPressed = 0;
        // Initialize views by ID
        timerTextView = findViewById(R.id.timer);
        graceTimerTextView = findViewById(R.id.timer2);
        scoreTextView = findViewById(R.id.score);
        levelTextView = findViewById(R.id.level);
        questionTextView = findViewById(R.id.question);
        userGreeting = findViewById(R.id.questionAnswerUserGreeting);
        userGreeting.setText("Hello " + extras.getString("username"));

        graceTimerTextView.setText("");


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

        scoreTextView.setText("Score: " + score);
        // Set up a sample question and answers
        displayQuestion("Sample question", new String[]{"Answer 1", "Answer 2", "Answer 3", "Answer 4"});

        // Set up answer button click listeners
        for (Button button : answerButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle answer selection and move to next question or end the quiz


                    if(picking2)
                    {
                        button.setBackgroundColor(getColor(R.color.titleBackground));
                        picking2Buttons[buttonsPressed] = button;
                        buttonsPressed++;
                        if(buttonsPressed == 2)
                        {
                            checkAnswer();
                        }

                    }
                    else if(secondChancing)
                    {
                        if(button != trueAnswer)
                        {
                            button.setBackgroundColor(getColor(R.color.teal_700));
                        }
                        secondChancing = false;
                    }
                    else
                    {
                        checkAnswer();
                    }
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
                            button.setBackgroundColor(getResources().getColor(R.color.teal_700));
                            recheckButtons = true;
                            break;
                        }
                    }

                    lifelineButtons[0].setEnabled(false);
                    lifelineButtons[0].setBackgroundColor(getResources().getColor(R.color.teal_700));
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
                startTimer(10000, graceTimerTextView, false);
                lifelineButtons[2].setEnabled(false);
                lifelineButtons[2].setBackgroundColor(getResources().getColor(R.color.teal_700));
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
                        answerButtons[n].setBackgroundColor(getResources().getColor(R.color.teal_700));
                        recheckButtons = true;
                        l++;
                    }
                }
                while(l != 2);

                lifelineButtons[3].setEnabled(false);
                lifelineButtons[3].setBackgroundColor(getResources().getColor(R.color.teal_700));
            }
        });

        lifelineButtons[4].setOnClickListener(new View.OnClickListener() { //lifeline 5 2nd chance
            @Override
            public void onClick(View view) {
                secondChancing = true;
                lifelineButtons[4].setEnabled(false);
                lifelineButtons[4].setBackgroundColor(getResources().getColor(R.color.teal_700));
            }
        });

        lifelineButtons[5].setOnClickListener(new View.OnClickListener() { //lifeline 6 pick 2
            @Override
            public void onClick(View view) {
                picking2 = true;
                lifelineButtons[5].setEnabled(false);
                lifelineButtons[5].setBackgroundColor(getResources().getColor(R.color.teal_700));
            }
        });

        // Start a sample timer
        startTimer(10000, timerTextView, true);




//        if(!timerStatus && givenGrace)
//        {
//            // next question
//            timerStatus = true;
//            givenGrace = false;
//        }
    }


    public void recheckAllButtons() //make sure to run this after choice is made/before next question is pulled
    {
        for (Button button: answerButtons) {
            if(!button.isEnabled())
            {
                button.setEnabled(true);
                button.setBackgroundColor(getResources().getColor(R.color.purple_200));
            }
        }
    }

    // Assigns background color to show the correct answer and incorrect answers
    private void checkAnswer() {

        if(picking2)
        {
            if(picking2Buttons.length == 2)
            {
                for (Button but: picking2Buttons
                     ) {
                    if(but == trueAnswer)
                    {
                        //assign points chose right answer
                        break;
                    }
                }
                revealAnswer();
                picking2 = false;
            }
        }
        else
        {
            revealAnswer();
        }

    }

    private void revealAnswer()
    {
        for (Button button : answerButtons) {
            if (button == trueAnswer) {
                button.setBackgroundColor(getColor(R.color.green));
            } else {
                button.setBackgroundColor(getColor(R.color.red));
            }
        }

        buttonsPressed = 0;
        secondChancing = false;

        score += assignPoints(20); //whatever points they gets for each lifeline send here
        scoreTextView.setText("Score: " + score);

    }

    private int assignPoints(int lifelinePointby)
    {
        int additionalPoints = 0;
        for (Button lifeBut: lifelineButtons
             ) {
            if(lifeBut.isEnabled())
            {
                additionalPoints += lifelinePointby;
            }
        }

        return additionalPoints;
    }

    private void displayQuestion(String questionText, String[] answers) {
        questionTextView.setText(questionText);
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answers[i]);
        }
        Random rand = new Random();
        trueAnswer = answerButtons[rand.nextInt(3)];
    }

    private void startTimer(long timeMillis, TextView textV, boolean usingMainTimer) {
        new CountDownTimer(timeMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                textV.setText(String.format("%.1f", millisUntilFinished / 1000.0));
            }

            @Override
            public void onFinish() {
                // Handle timer expiration

                if(usingMainTimer)//automatically start grace  period
                {
                    startTimer(5000, graceTimerTextView, false);
                }

                //move to next question


            }
        }.start();
    }
}