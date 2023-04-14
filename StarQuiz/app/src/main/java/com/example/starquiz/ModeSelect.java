package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ModeSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        Button returnButton = findViewById(R.id.infoButton);


        List<Button> modes = new ArrayList<>();

        // create and add 6 buttons(modes) to the list
        Button button1 = findViewById(R.id.mode10);
        modes.add(button1);
        Button button2 = findViewById(R.id.mode20);
        modes.add(button2);
        Button button3 = findViewById(R.id.mode30);
        modes.add(button3);
        Button button4 = findViewById(R.id.mode40);
        modes.add(button4);
        Button button5 = findViewById(R.id.mode50);
        modes.add(button5);
        Button button6 = findViewById(R.id.mode100);
        modes.add(button6);
        Button confirm = findViewById(R.id.confirm);

        // set the OnClickListener for each button to a single object
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Button button : modes) {
                    button.setActivated(button == v);
                    if (button.isActivated()) {
                        button.setBackgroundColor(Color.rgb(255, 255, 255));
                    }
                }
            }
        };

        //This creates a buttonClickListener for each button in the list.
        for (Button button : modes) {
            button.setOnClickListener(buttonClickListener);
        }

        //returnButton should go to the Info and Rules screen
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeSelect.this, InfoAndRulesActivity.class);
                startActivity(intent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button selectedButton = null;
                for (Button button : modes) {
                    if (button.isActivated()) {       //Checks if the button was tapped on or highlighted
                        selectedButton = button;
                        break;
                    }
                }
                if (selectedButton != null) {
                    Intent intent = new Intent(ModeSelect.this, InfoAndRulesActivity.class); //This should start the highlighted mode when ok is pressed.
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "You must select a mode", Toast.LENGTH_LONG).show(); //If a mode isn't selected, tell the user to pick something.
                }
            }
        });
    }
}
