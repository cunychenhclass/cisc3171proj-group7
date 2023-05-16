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
import java.util.Arrays;

public class SpecificLeaderboard extends AppCompatActivity {

    static LeaderboardArrayList cate10 = new LeaderboardArrayList();
    static LeaderboardArrayList cate20 = new LeaderboardArrayList();
    static LeaderboardArrayList cate30 = new LeaderboardArrayList();
    static LeaderboardArrayList cate40 =new LeaderboardArrayList();
    static LeaderboardArrayList cate50 = new LeaderboardArrayList();
    static LeaderboardArrayList cate100 = new LeaderboardArrayList();
    ArrayList<String> username;
    ArrayList<Integer> score;
    ArrayList<Float> time;
    String[] timeString;
    String currUser = "";
    TextView categoryName;
    int categoryNum;
    LeaderboardArrayList categoryusing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_leaderboard);

        Bundle bundle = getIntent().getExtras();
        categoryNum = bundle.getInt("categoryNum", categoryNum);

        submitUser(categoryNum);
        if (bundle.containsKey("playerName")) {
            String playerName = bundle.getString("playerName");
            int playerScore = bundle.getInt("playerScore");
            float playerTime = (float) bundle.getDouble("playerTime");
            currUser = playerName;
            categoryusing.addNewUser(playerName, playerScore, playerTime);
        }
        //categoryusing.addNewUser("Max", 6, 1f);

        if(categoryusing != null)
        {
            username = categoryusing.username;
            score = categoryusing.score;
            time = categoryusing.time;
        }

        if(time != null)
        {
            timeString = new String[time.size()];
            for (int i = 0; i < time.size(); i++) {
                timeString[i] = Float.toString(time.get(i));
            }
        }
        
        Button returnButton = findViewById(R.id.specificLeaderboardReturnButton);
        categoryName = findViewById(R.id.specificLeaderboardTitleText);
        categoryName.setText(categoryNum + " Questions Leaderboard");


        TableLayout mainLeaderboard = findViewById(R.id.specificLeaderboardTable);
        // Return to leaderboard select screen
        if(username != null)
        {
        // Populating the leaderboard with dummy data
        // It should be using the database once its implemented
            for (int i = 0; i < username.size(); i++) {
                mainLeaderboard.addView(createNewRow(i + 1, username.get(i), score.get(i), timeString[i]));
            }
        }
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpecificLeaderboard.this, LeaderboardSelect.class);
                startActivity(intent);
            }
        });

        ImageButton homeButton = findViewById(R.id.specificLeaderboardHomeButton);
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
        switch (cat)
        {
            case 10:
                categoryusing = cate10;
                break;
            case 20:
                categoryusing = cate20;
                break;
            case 30:
                categoryusing = cate30;
                break;
            case 40:
                categoryusing = cate40;
                break;
            case 50:
                categoryusing = cate50;
                break;
            case 100:
                categoryusing = cate100;
                break;
        }
    }
}


class LeaderboardArrayList{ //used as a custom array type for the category lists
    int size = 10;
    ArrayList<String> username = new ArrayList<String>(Arrays.asList("kyle", "jones", "James", "Tyler", "Kevin", "alex", "richie", "sasha", "beau"));
    ArrayList<Integer> score = new ArrayList<Integer>(Arrays.asList(323,240,235,230,120,115,110,105,45));
    ArrayList<Float> time = new ArrayList<Float>(Arrays.asList(10.512f,31.345f,9.134f,4.418f,15.516f,21.323f,2.298f,18.989f,7.615f));

    public void scrubArrays()
    {
        username = null;
        score = null;
        time = null;
    }

    public void addNewUser(String newUser, int newScore, float newTime) {
        for (int i = 0; i < score.size(); i++) {
            if (newScore > score.get(i)) {
                username.add(i, newUser);
                score.add(i, newScore);
                time.add(i, newTime);
                size++;
                return;
            } else if (newScore == score.get(i) && newTime > time.get(i)) {
                username.add(i, newUser);
                score.add(i, newScore);
                time.add(i, newTime);
                size++;
                return;
            }
        }
        username.add(newUser);
        score.add(newScore);
        time.add(newTime);
        size++;
    }

}

