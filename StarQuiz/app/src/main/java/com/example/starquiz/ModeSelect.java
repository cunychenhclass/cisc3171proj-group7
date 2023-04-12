package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ModeSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        Button returnButton = findViewById(R.id.infoButton);


        List<HighlightButton> modes = new ArrayList<>();

        // create and add 6 buttons to the list
        HighlightButton button1 = findViewById(R.id.mode10);
        modes.add(button1);
        HighlightButton button2 = findViewById(R.id.mode20);
        modes.add(button2);
        HighlightButton button3 = findViewById(R.id.mode30);
        modes.add(button3);
        HighlightButton button4 = findViewById(R.id.mode40);
        modes.add(button4);
        HighlightButton button5 = findViewById(R.id.mode50);
        modes.add(button5);
        HighlightButton button6 = findViewById(R.id.mode100);
        modes.add(button6);

        // set the OnClickListener for each button to a single object
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (HighlightButton button : modes) {
                    button.setHighlighted(button == v);
                }
            }
        };

        for (HighlightButton button : modes) {
            button.setOnClickListener(buttonClickListener);
        }

        Button confirm = findViewById(R.id.confirm);

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
                Intent intent = new Intent(ModeSelect.this, InfoAndRulesActivity.class);
                startActivity(intent);
            }
        });
    }
}

class HighlightButton extends AppCompatButton {
    private boolean isHighlighted;

    public HighlightButton(Context context) {
        super(context);
        isHighlighted = false;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted = highlighted;
        updateBackground(); // call a method to update the button's background based on the highlight state
    }

    private void updateBackground() {
    }
}
