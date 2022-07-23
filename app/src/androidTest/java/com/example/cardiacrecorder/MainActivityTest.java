package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@LargeTest

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addButtonTest() {
        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.dateValue)).perform(ViewActions.typeText("12/10/2021"));
        onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("69"));
        pressBack();
        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();
        //pressBack();



        //  pressBack();
        //onView(withId(R.id.addActivity)).perform(swipeUp());
        onView(withId(R.id.saveButton)).perform(click());
        //onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

}