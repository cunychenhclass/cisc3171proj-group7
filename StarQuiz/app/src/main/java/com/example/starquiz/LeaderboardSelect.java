package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeaderboardSelect extends AppCompatActivity {

//    ArrayList<LeaderboardArrayList> cate10 = new ArrayList<>();
//    ArrayList<LeaderboardArrayList> cate20 = new ArrayList<>();
//    ArrayList<LeaderboardArrayList> cate30 = new ArrayList<>();
//    ArrayList<LeaderboardArrayList> cate40 = new ArrayList<>();
//    ArrayList<LeaderboardArrayList> cate50 = new ArrayList<>();
//    ArrayList<LeaderboardArrayList> cate100 = new ArrayList<>();

    ArrayList<Button> buttonsList = new ArrayList<>();
    int categoryusing;

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
                categoryusing = 10;
                colorChange(leaderboard10);
            }
        });

        leaderboard20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = 20;
                colorChange(leaderboard20);
            }
        });

        leaderboard30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = 30;
                colorChange(leaderboard30);
            }
        });

        leaderboard40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = 40;
                colorChange(leaderboard40);
            }
        });

        leaderboard50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = 50;
                colorChange(leaderboard50);
            }
        });

        leaderboard100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = 100;
                colorChange(leaderboard100);
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use category int
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

//    public void submitUser(int category_, String Username_, int Score_, float time_)
//    {
//        switch (category_)
//        {
//            case 10:
//                arrayListHandler(cate10, Username_, Score_, time_);
//                break;
//            case 20:
//                arrayListHandler(cate20, Username_, Score_, time_);
//                break;
//            case 30:
//                arrayListHandler(cate30, Username_, Score_, time_);
//                break;
//            case 40:
//                arrayListHandler(cate40, Username_, Score_, time_);
//                break;
//            case 50:
//                arrayListHandler(cate50, Username_, Score_, time_);
//                break;
//            case 100:
//                arrayListHandler(cate100, Username_, Score_, time_);
//                break;
//        }
//    }

//    public void arrayListHandler(ArrayList<LeaderboardArrayList> category, String Username_, int Score_, float time_)
//    {
//        for(int i = 0; i < category.size() - 1; i++)
//        {
//            if(category.get(i).username == Username_)
//            {
//                if(category.get(i).score < Score_)
//                {category.get(i).score = Score_;}
//            }
//            else
//            {
//                category.add( new LeaderboardArrayList(Username_, Score_, time_));
//            }
//        }
//    }

}

//class LeaderboardArrayList{ //used as a custom array type for the category lists
//    int size = 10;
//    String username;
//    int score;
//    float time;
//    LeaderboardArrayList( String Username_, int Score_, float time_)
//    { //holds the individual datas to find the users
//        this.username = Username_;
//        this.score = Score_;
//        this.time = time_;
//    }
//
//
//}