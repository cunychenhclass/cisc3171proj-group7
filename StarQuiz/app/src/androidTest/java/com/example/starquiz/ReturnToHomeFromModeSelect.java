package com.example.starquiz;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

public class ReturnToHomeFromModeSelect {

    @Rule
    public ActivityScenarioRule<ModeSelect> mActivityScenarioRule =
            new ActivityScenarioRule<>(ModeSelect.class);

    @Test
    public void returnToHomeFromModeSelect() {
        onView(withId(R.id.ModeSelectHomeButton)).perform(click());
    } //Very quickly returns to the home screen

}
