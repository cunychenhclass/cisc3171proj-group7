package com.example.starquiz;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SpecificLeaderboardEspressoTest {

    @Rule
    public ActivityScenarioRule<LeaderboardSelect> activityRule =
            new ActivityScenarioRule<>(LeaderboardSelect.class);

    @Test
    public void testForAppNameBeingDisplayed() {
        onView(withId(R.id.button10Leaderboard)).perform(click());

        onView(withId(R.id.nextLeaderboardSelectButton)).perform(click());

        onView(withId(R.id.specificLeaderboardTitleText)).check(matches(withText("10 Questions Leaderboard")));
    }

    // This is for the specific leaderboard user story Scenario 1
    @Test
    public void clickReturnButton() {
        onView(withId(R.id.button10Leaderboard)).perform(click());

        onView(withId(R.id.nextLeaderboardSelectButton)).perform(click());

        onView(withId(R.id.specificLeaderboardReturnButton)).perform(click());

        onView(withId(R.id.button10Leaderboard)).check(matches(isDisplayed()));
    }

    @Test
    public void clickHomeButton() {
        onView(withId(R.id.button10Leaderboard)).perform(click());

        onView(withId(R.id.nextLeaderboardSelectButton)).perform(click());

        onView(withId(R.id.specificLeaderboardHomeButton)).perform(click());

        onView(withId(R.id.appName)).check(matches(isDisplayed()));
    }



}