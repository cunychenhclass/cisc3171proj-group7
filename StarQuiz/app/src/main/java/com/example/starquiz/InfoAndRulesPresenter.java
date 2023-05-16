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

    private void showCurrentPage() {
        String currentPage = model.getCurrentPage();
        view.showInfoPage(currentPage);
    }

    public void onReturnButtonClicked() {
        view.finishActivity();
    }

    public void onNextButtonClicked() {
        model.goToNextPage();
        updateButtonsVisibility();
        showCurrentPage();
    }

    public void onPreviousButtonClicked() {
        model.goToPreviousPage();
        updateButtonsVisibility();
        showCurrentPage();
    }

    public void onOkButtonClicked() {
        view.navigateToModeSelectActivity(extras);
    }
}


