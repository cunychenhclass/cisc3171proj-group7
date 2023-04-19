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
import java.util.Random;

public class LeaderboardSelect extends AppCompatActivity {

    LeaderboardArrayList cate10;
    LeaderboardArrayList cate20;
    LeaderboardArrayList cate30;
    LeaderboardArrayList cate40;
    LeaderboardArrayList cate50;
    LeaderboardArrayList cate100;

    ArrayList<Button> buttonsList = new ArrayList<>();
    LeaderboardArrayList categoryusing;
    int categoryNum;

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
                finish();
            }
        });

        leaderboard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = cate10;
                colorChange(leaderboard10);
                categoryNum = 10;
            }
        });

        leaderboard20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = cate20;
                colorChange(leaderboard20);
                categoryNum = 20;
            }
        });

        leaderboard30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = cate30;
                colorChange(leaderboard30);
                categoryNum = 30;
            }
        });

        leaderboard40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = cate40;
                colorChange(leaderboard40);
                categoryNum = 40;
            }
        });

        leaderboard50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = cate50;
                colorChange(leaderboard50);
                categoryNum = 50;
            }
        });

        leaderboard100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryusing = cate100;
                colorChange(leaderboard100);
                categoryNum = 100;
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use category int
                testStocks(categoryusing);
                Intent intent = new Intent(LeaderboardSelect.this, SpecificLeaderboard.class);
                intent.putExtra("categoryNum", categoryNum);
                intent.putStringArrayListExtra("NamesList", categoryusing.username);
                intent.putIntegerArrayListExtra("ScoreList", categoryusing.score);
                intent.putExtra("TimeList", categoryusing.time);
                startActivity(intent);

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

//    public void submitUser(LeaderboardArrayList category, String Username_, int Score_, float time_)
//    {
//        switch (category_)
//        {
//            case 10:
//
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

    public void arrayListHandler(LeaderboardArrayList category, String Username_, int Score_, long time_)
    {
        for(int i = 0; i < category.username.size(); i++)
        {
            if(category.username.get(i) == Username_)
            {
                if(category.score.get(i) < Score_)
                {
                    category.score.set(i, Score_);
                    category.time.set(i, time_);
                }
            }
            else
            {
                category.username.add(Username_);
                category.score.add(Score_);
                category.time.add(time_);
            }
        }
    }

    public void testStocks(LeaderboardArrayList category)
    {
        String[] names = { "kyle", "jones", "James", "Tyler", "Kevin", "alex", "richie", "sasha", "beau"};
        category.scrubArrays();
        Random random = new Random();
        for (int i = 0; i < names.length; i++)
        {
            arrayListHandler(category, names[i], random.nextInt(999), random.nextLong());
        }

    }


}

class LeaderboardArrayList{ //used as a custom array type for the category lists
    int size = 10;
    ArrayList<String> username = new ArrayList<>();
    ArrayList<Integer> score = new ArrayList<>();
    ArrayList<Long> time = new ArrayList<>();

    //final float[] arr = new float[time.size()];
//    LeaderboardArrayList( String Username_, int Score_, float time_)
//    { //holds the individual datas to find the users
//        this.username.add(Username_);
//        this.score.add(Score_);
//        this.time.add(time_);
//    }

    public void scrubArrays()
    {
        username.clear();
        score.clear();
        time.clear();
    }


}