package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Countdown extends AppCompatActivity {

    TextView threeText;
    TextView twoText;
    TextView oneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        threeText = findViewById(R.id.threeCountdown);
        twoText = findViewById(R.id.twoCountdown);
        oneText = findViewById(R.id.oneCountdown);

        fadeInAnimation(threeText);

    }


    //TODO, Refactor all this code as it does work but it looks messy

    public void fadeOutAnimation(TextView text) {
        Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(750);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                text.setAlpha(0.0f);
                int currCount = Integer.parseInt(text.getText().toString());
                if (currCount == 3) {
                    fadeInAnimation(twoText);
                } else if (currCount == 2) {
                    fadeInAnimation(oneText);
                } else {
                    Log.i("Countdown", "Should move to next screen here");
                    Intent intent = new Intent(Countdown.this, QuestionAnswerActivity.class);
                    intent.putExtras(getIntent());
                    startActivity(intent);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        text.startAnimation(out);
    }

    public void fadeInAnimation(TextView text) {
        text.setAlpha(1.0f);
        Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(750);

        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeOutAnimation(text);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        text.startAnimation(in);
    }

    // This is an alternative way to doing the animation
        /*public void fadeInAnimation(TextView text) {
        text.setAlpha(1.0f);
        Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(750);

        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeOutAnimation(text);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        text.startAnimation(in);
    }

    public void fadeOutAnimation(TextView text) {
        Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(750);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                text.setAlpha(0.0f);
                int currentCount = Integer.parseInt(text.getText().toString());
                if (currentCount > 1) {
                    currentCount--;
                    text.setText(currentCount + "");
                    fadeInAnimation(text);
                } else {
                    Log.i("Countdown", "moving to new screen");
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        text.startAnimation(out);
    }*/
}