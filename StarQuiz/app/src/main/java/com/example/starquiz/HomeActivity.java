// Import necessary classes and packages
package com.example.starquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TreeSet;
import java.util.Set;

// MainActivity base class for activities
public class HomeActivity extends AppCompatActivity {

    // Private variables for EditText, username, and bannedUsernames
    private EditText usernameEditText;
    private String username;
    private Set<String> bannedUsernames;

    // onCreate method called when activity created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        // Find views by their ID in layout and assign them to variables
        TextView appName = findViewById(R.id.appName);
        usernameEditText = findViewById(R.id.usernameEditText);
        Button enterButton = findViewById(R.id.enterButton);
        Button leaderboardsButton = findViewById(R.id.leaderboardsButton);
        Button infoRulesButton = findViewById(R.id.infoRulesButton);
        Button themesButton = findViewById(R.id.themesButton);

        // Initialize bannedUsernames set
        bannedUsernames = new TreeSet<>();
        // bannedUsername DB implementation here

        // Set onClickListener for enterButton to handle user clicks
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get entered username from EditText and trim any whitespace
                username = usernameEditText.getText().toString().trim();

                // Check if entered username is valid
                if (isValidUsername(username) && username.length() >= 3 &&  username.length() <= 25) {
                    // If username is valid create an intent to navigate to the InfoAndRulesActivity
                    Intent intent = new Intent(HomeActivity.this, InfoAndRulesActivity.class);
                    // Pass username to next activity using intent.putExtra
                    intent.putExtra("username", username);
                    // Start InfoAndRulesActivity
                    startActivity(intent);
                } else {
                    // If username is invalid show a toast message informing the user
                    Toast.makeText(HomeActivity.this, "Invalid username. Please choose another.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListener for leaderboardsButton to navigate to LeaderboardSelectActivity
        leaderboardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LeaderboardSelect.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for infoRulesButton to navigate to InfoAndRulesActivity
        infoRulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InfoAndRulesActivity.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for themesButton to navigate to ThemesActivity
        themesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(HomeActivity.this, ThemesActivity.class);
               // startActivity(intent);
            }
        });
    }

    // Private helper method to check if a username is valid
    private boolean isValidUsername(String username) {
        // Return true if username is not empty and is not in bannedUsernames database. Implementation to be determined.
        return !username.isEmpty() && !bannedUsernames.contains(username);
    }
}