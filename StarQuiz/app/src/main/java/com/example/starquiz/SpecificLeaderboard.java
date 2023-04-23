package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class SpecificLeaderboard extends AppCompatActivity {
    String[] username;
    int[] score;
    float[] time;
    String[] timeString;
    String currUser;
    TextView categoryName;
    int categoryNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_leaderboard);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        categoryNum = bundle.getInt("categoryNum", categoryNum);
        username = bundle.getStringArray("NamesList");
        score = bundle.getIntArray("ScoreList");
        time = bundle.getFloatArray("TimeList");


        if(time != null)
        {
            timeString = new String[time.length];
            for (int i = 0; i < time.length; i++) {
                timeString[i] = Float.toString(time[i]);
            }
        }


        
        Button returnButton = findViewById(R.id.specificLeaderboardReturnButton);
        categoryName = findViewById(R.id.specificLeaderboardTitleText);
        categoryName.setText(categoryNum + " Questions Leaderboard");

        //TODO edit the title textview so that it doesn't expand all the way to the end of the screen

        TableLayout mainLeaderboard = findViewById(R.id.specificLeaderboardTable);
        currUser = "Kevin";
        // Return to leaderboard select screen
        if(score != null)
        {
        // Populating the leaderboard with dummy data
        // It should be using the database once its implemented
            for (int i = 0; i < username.length; i++) {
                mainLeaderboard.addView(createNewRow(i + 1, username[i], score[i], timeString[i]));
            }
        }

//        for (int i = 1; i <= 100; i++) {
//            mainLeaderboard.addView(createNewRow(i, "Test User", 500, "00:05:30"));
//        }
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // Creates a new row for the leaderboard and setting the format of the textviews
    public TableRow createNewRow(int rank, String name, long score, String time) {
        TableRow row = new TableRow(this);

        TextView rankText = new TextView(this);
        TextView nameText = new TextView(this);
        TextView scoreText = new TextView(this);
        TextView timeText = new TextView(this);

        rankText.setText(Integer.toString(rank));
        nameText.setText(name);
        scoreText.setText(Long.toString(score));
        timeText.setText(time);

        ArrayList<TextView> rowData = new ArrayList<TextView>();
        rowData.add(rankText);
        rowData.add(nameText);
        rowData.add(scoreText);
        rowData.add(timeText);

        for (TextView text : rowData) {
            text.setBackgroundResource(R.drawable.border);

            if (currUser.equals(name)) {
                text.setTextColor(getColor(R.color.yellow));
            } else {
                text.setTextColor(getColor(R.color.white));
            }

            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            text.setTextSize(18f);
            row.addView(text);
        }
        return row;
    }
}

