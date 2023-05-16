package com.example.starquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class InfoAndRulesActivity extends AppCompatActivity implements InfoAndRulesView {
    private InfoAndRulesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_and_rules);

        // Create the Model with the info pages data
        List<String> infoPages = Arrays.asList(
                "Overview: Test your Video Game knowledge across all historical accounts.\n" +
                "        Race against time, answer correctly, and rack up points.\n" +
                "        Learn about lifeline mechanics in the next page and timer mechanics on the third page.\n" +
                "        Each category is scaled by difficulty, leaving the last category at the bottom to challenge yourself.\n" +
                "        Earn more points depending on the difficulty of the Questions.",

                "Lifelines:\n" +
                "Remove 1: This removes one of the incorrect answer choices from the list.\n\n" +
                "50/50: Removes two wrong answers.\n\n" +
                "2nd Chance: Within 2 seconds after timer expires, redo question with previous guess removed.\n\n" +
                "Pick 2: Choose two answers.\n\n" +
                "Skip question: Bypass question, gain max points.\n\n" +
                "Restore timer: Resets the timer back to 10 seconds.",

                "Timer Rules:\n" +
                "You will have ten seconds for each question. If the timer hits zero, the question will be skipped " +
                "and you will receive 0 points for the question. The faster you can correctly answer the question, " +
                "the more points you gain.");

        InfoAndRulesModel model = new InfoAndRulesModel(infoPages);

// Get the extras from the Intent
        Bundle extras = getIntent().getExtras();

// Create the Presenter with the View, Model, and extras
        presenter = new InfoAndRulesPresenter(this, model, extras);
        presenter.initialize();

        Button returnButton = findViewById(R.id.infoAndRulesReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onReturnButtonClicked();
            }
        });

        Button okButton = findViewById(R.id.infoAndRulesOkButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOkButtonClicked();
            }
        });

        ImageButton nextButton = findViewById(R.id.InfoNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onNextButtonClicked();
            }
        });

        ImageButton previousButton = findViewById(R.id.InfoPrevious);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPreviousButtonClicked();
            }
        });

    }

    @Override
    public void showInfoPage(String text) {
        TextView infoAndRulesTextView = findViewById(R.id.infoAndRulesDesc);
        infoAndRulesTextView.setText(text);
    }

    @Override
    public void showPreviousButton() {
        ImageButton previousButton = findViewById(R.id.InfoPrevious);
        previousButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNextButton() {
        ImageButton nextButton = findViewById(R.id.InfoNext);
        nextButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePreviousButton() {
        ImageButton previousButton = findViewById(R.id.InfoPrevious);
        previousButton.setVisibility(View.GONE);
    }

    @Override
    public void hideNextButton() {
        ImageButton nextButton = findViewById(R.id.InfoNext);
        nextButton.setVisibility(View.GONE);
    }

    @Override
    public void showOkButton() {
        Button okButton = findViewById(R.id.infoAndRulesOkButton);
        okButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideOkButton() {
        Button okButton = findViewById(R.id.infoAndRulesOkButton);
        okButton.setVisibility(View.GONE);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void navigateToModeSelectActivity(Bundle extras) {
        Intent intent = new Intent(InfoAndRulesActivity.this, ModeSelect.class);
        intent.putExtras(extras);
        startActivity(intent);
    }

}