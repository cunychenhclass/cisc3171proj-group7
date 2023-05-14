package com.example.starquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SpecificLeaderboard extends AppCompatActivity {

    LeaderboardArrayList cate10;
    LeaderboardArrayList cate20;
    LeaderboardArrayList cate30;
    LeaderboardArrayList cate40;
    LeaderboardArrayList cate50;
    LeaderboardArrayList cate100;
    String[] username;
    int[] score;
    float[] time;
    String[] timeString;
    String currUser;
    TextView categoryName;
    int categoryNum;
    LeaderboardArrayList categoryusing = new LeaderboardArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_leaderboard);

        Intent intent = getIntent();
        categoryNum = intent.getIntExtra("categoryNum", categoryNum);
//        username = bundle.getStringArray("NamesList");
//        score = bundle.getIntArray("ScoreList");
//        time = bundle.getFloatArray("TimeList");

        submitUser(categoryNum);

        if(categoryusing != null)
        {
            username = categoryusing.username;
            score = categoryusing.score;
            time = categoryusing.time;
        }


        ImageButton homeButton = findViewById(R.id.specificLeaderboardHomeButton);


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

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpecificLeaderboard.this, HomeActivity.class);
                startActivity(intent);
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

    public void submitUser(int cat)
    {
//        switch (cat)
//        {
//            case 10:
//                categoryusing = cate10;
//                break;
//            case 20:
//                categoryusing = cate20;
//                break;
//            case 30:
//                categoryusing = cate30;
//                break;
//            case 40:
//                categoryusing = cate40;
//                break;
//            case 50:
//                categoryusing = cate50;
//                break;
//            case 100:
//                categoryusing = cate100;
//                break;
//        }
    }
}


class LeaderboardArrayList{ //used as a custom array type for the category lists
    int size = 10;
    String[] username = {"kyle", "jones", "James", "Tyler", "Kevin", "alex", "richie", "sasha", "beau"};

    int[] score = {1,2,3,4,5,6,7,8,9};

    float[] time = {900.0f,800.0f,700.0f,600.0f,500.0f,400.0f,300.0f,200.0f,100.0f};


    public void scrubArrays()
    {
        username = null;
        score = null;
        time = null;
    }


}

