package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class LeaderboardSelect extends AppCompatActivity {

//    LeaderboardArrayList cate10;
//    LeaderboardArrayList cate20;
//    LeaderboardArrayList cate30;
//    LeaderboardArrayList cate40;
//    LeaderboardArrayList cate50;
//    LeaderboardArrayList cate100;

    ArrayList<Button> buttonsList = new ArrayList<>();
//    LeaderboardArrayList categoryusing = new LeaderboardArrayList();
    int categoryNum = 0;
//    String[] username;
//    int[] score;
//    float[] time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_select);

        Button leaderboard10 = (Button)findViewById(R.id.button10Leaderboard);
        Button leaderboard20 = (Button)findViewById(R.id.button20Leaderboard);
        Button leaderboard30 = (Button)findViewById(R.id.button30Leaderboard);
        Button leaderboard40 = (Button)findViewById(R.id.button40Leaderboard);
        Button leaderboard50 = (Button)findViewById(R.id.button50Leaderboard);
        Button leaderboard100 = (Button)findViewById(R.id.button100Leaderboard);

        buttonsList.add(leaderboard10);
        buttonsList.add(leaderboard20);
        buttonsList.add(leaderboard30);
        buttonsList.add(leaderboard40);
        buttonsList.add(leaderboard50);
        buttonsList.add(leaderboard100);

//        if(categoryusing != null)
//        {
//            username = categoryusing.username;
//            score = categoryusing.score;
//            time = categoryusing.time;
//        }

        ImageButton returnButton = (ImageButton)findViewById(R.id.returnButtonLeaderboard);
        Button selectButton = (Button)findViewById(R.id.nextLeaderboardSelectButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        leaderboard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                categoryusing = cate10;
                colorChange(leaderboard10);
                categoryNum = 10;

            }
        });

        leaderboard20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                categoryusing = cate20;
                colorChange(leaderboard20);
                categoryNum = 20;

            }
        });

        leaderboard30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                categoryusing = cate30;
                colorChange(leaderboard30);
                categoryNum = 30;
            }
        });

        leaderboard40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                categoryusing = cate40;
                colorChange(leaderboard40);
                categoryNum = 40;
            }
        });

        leaderboard50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                categoryusing = cate50;
                colorChange(leaderboard50);
                categoryNum = 50;
            }
        });

        leaderboard100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                categoryusing = cate100;
                colorChange(leaderboard100);
                categoryNum = 100;
            }
        });

//        username = categoryusing.username;
//        score = categoryusing.score;
//        time = categoryusing.time;

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use category int
                if(categoryNum != 0)
                {
                    Intent intent = new Intent(LeaderboardSelect.this, SpecificLeaderboard.class);
                    intent.putExtra("categoryNum", categoryNum);
//                bundle.putStringArray("NamesList", username);
//                bundle.putIntArray("ScoreList", score);
//                bundle.putFloatArray("TimeList", time);
                    startActivity(intent);
                }

            }
        });

    }

    public void colorChange(Button category_)
    {
        for (Button b: buttonsList) {
            b.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        }

        category_.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }


    public void arrayListHandler(LeaderboardArrayList category, String Username_, int Score_, float time_)
    {
        for(int i = 0; i < category.username.length; i++)
        {
            if(category.username[i] == Username_)
            {
                if(category.score[i] < Score_)
                {
                    category.score[i] = Score_;
                    category.time[i] = time_;
                }
            }
            else
            {
                category.username[category.username.length + 1] = Username_;
                category.score[category.username.length + 1] = Score_;
                category.time[category.username.length + 1] = time_;
            }
        }
    }

//    public void testStocks(LeaderboardArrayList category)
//    {
//        String[] names = { "kyle", "jones", "James", "Tyler", "Kevin", "alex", "richie", "sasha", "beau"};
//        category.scrubArrays();
//        Random random = new Random();
//        for (int i = 0; i < names.length; i++)
//        {
//            arrayListHandler(category, names[i], random.nextInt(100), 500);
//        }
//
//    }


}

