package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@LargeTest

public class StartingActivityTest {

    @Rule
    public ActivityScenarioRule<StartingActivity> startingActivityActivityScenarioRule = new ActivityScenarioRule<StartingActivity>(StartingActivity.class);

    @Test
    public void testSplashScreen() {
        onView(withId(R.id.ic_logo)).check(matches(isDisplayed()));
        onView(withText("Cardiac Recorder")).check(matches(isDisplayed()));
    }



}