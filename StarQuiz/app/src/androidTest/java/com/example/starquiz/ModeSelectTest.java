package com.example.starquiz;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class ModeSelectTest {

    @Rule
    public ActivityScenarioRule<ModeSelect> mActivityScenarioRule =
            new ActivityScenarioRule<>(ModeSelect.class);

    @Test
    public void testMode()
    {
        onView(withId(R.id.mode30)).perform(click());
        onView(withId(R.id.modeSelectOk)).perform(click());
    } //it will say it has failed since it does not start at home activity and input username however is working as intended
    //since the buttons are meant to transfer scenes and stop the user is requirements are not met
}
