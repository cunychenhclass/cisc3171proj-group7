package com.example.starquiz;

import android.os.Bundle;

//Methods will be implemented in the actual InfoAndRulesActivity itself
public interface InfoAndRulesView {
    void showInfoPage(String text);
    void showPreviousButton();
    void showNextButton();
    void hidePreviousButton();
    void hideNextButton();
    void showOkButton();
    void hideOkButton();
    void finishActivity();
    void navigateToModeSelectActivity(Bundle extras);
}


