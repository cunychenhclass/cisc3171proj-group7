package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpecificLeaderboard extends AppCompatActivity {

    String currUser;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_leaderboard);

        Button returnButton = findViewById(R.id.specificLeaderboardReturnButton);

        TableLayout mainLeaderboard = findViewById(R.id.specificLeaderboardTable);

        title = findViewById(R.id.SpecificLeaderBoardTitleText);

        Bundle extras = getIntent().getExtras();

        String currMode = extras.get("LeaderboardCategory").toString();

        title.setText(currMode + " Questions Leaderboard");

        currUser = "Max";

        // Populating the leaderboard with dummy data
        // It should be using the database once its implemented
        mainLeaderboard.addView(createNewRow(1, "Max", 1000000, "00:05:30"));
        for (int i = 1; i <= 100; i++) {
            mainLeaderboard.addView(createNewRow(i+1,"Test User", 10000 - i * 100, "00:05:30"));
        }
        // Return to leaderboard select screen
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

