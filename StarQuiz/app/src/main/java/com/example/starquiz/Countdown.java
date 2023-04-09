package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        TextView threeText = findViewById(R.id.threeCountdown);
        TextView twoText = findViewById(R.id.twoCountdown);
        TextView oneText = findViewById(R.id.oneCountdown);

        fadeInAnimation(threeText, twoText, oneText);

    }

    //TODO, Refactor all this code as it does work but it looks messy

    public void fadeOutAnimation(TextView text, TextView nextText, TextView lastText) {
        Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(1000);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                text.setAlpha(0.0f);
                if (nextText != null) {
                    fadeInAnimation(nextText, lastText, null);
                } else {
                    Log.i("going to new screen","we are done with counting");
                    //Intent intent = new Intent(Countdown.this, Quiz.class);
                    //startActivity(intent);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        text.startAnimation(out);
    }

    public void fadeInAnimation(TextView text, TextView nextText, TextView lastText) {
        text.setAlpha(1.0f);
        Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(1000);

        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                text.setAlpha(1.0f);
                if (nextText != null) {
                    fadeOutAnimation(text, nextText, lastText);
                } else {
                    fadeOutAnimation(text, null, null);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        text.startAnimation(in);
    }
}