package com.example.starquiz;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HomeActivityUsernameTest {

    @Rule
    public ActivityScenarioRule<HomeActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void homeActivityUsernameTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        onView(withId(R.id.usernameEditText)).perform(typeText("John"));
        onView(withId(R.id.enterButton)).perform(click());
        onView(withId(R.id.infoAndRulesOkButton)).perform(click());
        onView(withId(R.id.mode100)).perform(click());
        onView(withId(R.id.modeSelectOk)).perform(click());
//        try {
//            Thread.sleep(2000);
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }
        onView(withId(R.id.questionAnswerUserGreeting)).check(matches(withText("Hello John")));
    }

    @Test
    public void invalidUsername() {
        onView(withId(R.id.usernameEditText)).perform(typeText("A"));
        onView(withId(R.id.enterButton)).perform(click());
        // onView(withId(R.id.infoAndRulesOkButton)).perform(click());

        onView(withId(R.id.enterButton)).check(matches(isDisplayed()));
    }
}
