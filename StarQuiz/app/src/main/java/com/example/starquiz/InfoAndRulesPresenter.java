package com.example.starquiz;

import android.os.Bundle;

public class InfoAndRulesPresenter {
    private InfoAndRulesView view;
    private InfoAndRulesModel model;
    private Bundle extras;

    public InfoAndRulesPresenter(InfoAndRulesView view, InfoAndRulesModel model, Bundle extras) {
        this.view = view;
        this.model = model;
        this.extras = extras;
    }

    public void initialize() {
        // Show or hide the "Ok" button based on the presence of data in extras
        if (extras != null && extras.containsKey("username")) {
            view.showOkButton();
        } else {
            view.hideOkButton();
        }

        updateButtonsVisibility();
        showCurrentPage();
    }

    //This is so that the user doesn't click on the previous button when they're only at the beginning of the activity and vice-versa
    private void updateButtonsVisibility() {
        if (model.currentPageIndex == 0) {
            view.hidePreviousButton();
        } else {
            view.showPreviousButton();
        }

        if (model.currentPageIndex == model.infoPages.size() - 1) {
            view.hideNextButton();
        } else {
            view.showNextButton();
        }
    }

    //Displays the current page
    private void showCurrentPage() {
        String currentPage = model.getCurrentPage();
        view.showInfoPage(currentPage);
    }

    //Returns to home screen when clicked on
    public void onReturnButtonClicked() {
        view.finishActivity();
    }

    //"Turns the page" to the next section of the rules
    public void onNextButtonClicked() {
        model.goToNextPage();
        updateButtonsVisibility();
        showCurrentPage();
    }

    //"Turns the page" to the previous section of the rules
    public void onPreviousButtonClicked() {
        model.goToPreviousPage();
        updateButtonsVisibility();
        showCurrentPage();
    }

    //Proceeds to Mode Select screen
    public void onOkButtonClicked() {
        view.navigateToModeSelectActivity(extras);
    }
}


