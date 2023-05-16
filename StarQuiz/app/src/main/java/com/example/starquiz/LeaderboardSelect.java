package com.example.starquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LeaderboardSelect extends AppCompatActivity {

    ArrayList<Button> buttonsList = new ArrayList<>();
    int categoryNum = 0;
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


        ImageButton returnButton = (ImageButton)findViewById(R.id.returnButtonLeaderboard);
        Button selectButton = (Button)findViewById(R.id.nextLeaderboardSelectButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeaderboardSelect.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        leaderboard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChange(leaderboard10);
                categoryNum = 10;

            }
        });

        leaderboard20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChange(leaderboard20);
                categoryNum = 20;

            }
        });

        leaderboard30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChange(leaderboard30);
                categoryNum = 30;
            }
        });

        leaderboard40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChange(leaderboard40);
                categoryNum = 40;
            }
        });

        leaderboard50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChange(leaderboard50);
                categoryNum = 50;
            }
        });

        leaderboard100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChange(leaderboard100);
                categoryNum = 100;
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use category int
                if(categoryNum != 0)
                {
                    Intent intent = new Intent(LeaderboardSelect.this, SpecificLeaderboard.class);
                    intent.putExtra("categoryNum", categoryNum);
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
}

