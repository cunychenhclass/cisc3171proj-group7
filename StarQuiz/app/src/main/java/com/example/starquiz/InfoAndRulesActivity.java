package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoAndRulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_and_rules);

        Bundle extras = getIntent().getExtras();

        Button returnButton = (Button)findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button okButton = (Button)findViewById(R.id.okButton);

        // To prevent the user from getting into the quiz without logging in
        if (extras == null || !extras.containsKey("username")) {
            okButton.setVisibility(View.INVISIBLE);
        }

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoAndRulesActivity.this, ModeSelect.class);
                startActivity(intent);
            }
        });
    }
}