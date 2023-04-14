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

    List<Button> modes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        Button returnButton = findViewById(R.id.infoButton);

        // create and add 6 buttons(modes) to the list
        Button mode10 = findViewById(R.id.mode10);
        modes.add(mode10);
        Button mode20 = findViewById(R.id.mode20);
        modes.add(mode20);
        Button mode30 = findViewById(R.id.mode30);
        modes.add(mode30);
        Button mode40 = findViewById(R.id.mode40);
        modes.add(mode40);
        Button mode50 = findViewById(R.id.mode50);
        modes.add(mode50);
        Button mode100 = findViewById(R.id.mode100);
        modes.add(mode100);

        Button confirm = findViewById(R.id.confirm);

        //Each of the following mode buttons ensures that when tapping on a button, the button is activated and
        //highlighted with colorChange while deactivating all
        //other buttons
        mode10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode10.setActivated(true);
                mode20.setActivated(false);
                mode30.setActivated(false);
                mode40.setActivated(false);
                mode50.setActivated(false);
                mode100.setActivated(false);

                colorChange(mode10);
            }
        });

        mode20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode10.setActivated(false);
                mode20.setActivated(true);
                mode30.setActivated(false);
                mode40.setActivated(false);
                mode50.setActivated(false);
                mode100.setActivated(false);

                colorChange(mode20);
            }
        });

        mode30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode10.setActivated(false);
                mode20.setActivated(false);
                mode30.setActivated(true);
                mode40.setActivated(false);
                mode50.setActivated(false);
                mode100.setActivated(false);

                colorChange(mode30);
            }
        });

        mode40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode10.setActivated(false);
                mode20.setActivated(false);
                mode30.setActivated(false);
                mode40.setActivated(true);
                mode50.setActivated(false);
                mode100.setActivated(false);

                colorChange(mode40);
            }
        });

        mode50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode10.setActivated(false);
                mode20.setActivated(false);
                mode30.setActivated(false);
                mode40.setActivated(false);
                mode50.setActivated(true);
                mode100.setActivated(false);

                colorChange(mode50);
            }
        });

        mode100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode10.setActivated(false);
                mode20.setActivated(false);
                mode30.setActivated(false);
                mode40.setActivated(false);
                mode50.setActivated(false);
                mode100.setActivated(true);

                colorChange(mode100);
            }
        });

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

    //for loop will change all other mode buttons to original color while highlighting the selected button with purple_200
    public void colorChange(Button category_)
    {
        for (Button b: modes) {
            b.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        }

        category_.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }
}
