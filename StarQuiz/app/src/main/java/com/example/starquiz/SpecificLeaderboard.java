package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpecificLeaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_leaderboard);

        Button returnButton = findViewById(R.id.specificLeaderboardReturnButton);

        TableLayout mainLeaderboard = findViewById(R.id.specificLeaderboardTable);
        for (int i = 1; i <= 100; i++) {
            mainLeaderboard.addView(createNewRow(i, "Test User", 500, "00:05:30"));
        }
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public TableRow createNewRow(int rank, String name, long score, String time) {
        TableRow row = new TableRow(this);

        TextView rankText = new TextView(this);
        TextView nameText = new TextView(this);
        TextView scoreText = new TextView(this);
        TextView timeText = new TextView(this);

        rankText.setBackgroundResource(R.drawable.border);
        nameText.setBackgroundResource(R.drawable.border);
        scoreText.setBackgroundResource(R.drawable.border);
        timeText.setBackgroundResource(R.drawable.border);

        rankText.setText(Integer.toString(rank));
        nameText.setText(name);
        scoreText.setText(Long.toString(score));
        timeText.setText(time);

        rankText.setTextColor(getColor(R.color.white));
        nameText.setTextColor(getColor(R.color.white));
        scoreText.setTextColor(getColor(R.color.white));
        timeText.setTextColor(getColor(R.color.white));

        rankText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        nameText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        scoreText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        timeText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        rankText.setTextSize(18f);
        nameText.setTextSize(18f);
        scoreText.setTextSize(18f);
        timeText.setTextSize(18f);

        row.addView(rankText);
        row.addView(nameText);
        row.addView(scoreText);
        row.addView(timeText);
        return row;
    }
}

