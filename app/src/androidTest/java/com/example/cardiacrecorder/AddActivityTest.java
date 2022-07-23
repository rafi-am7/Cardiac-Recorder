package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@LargeTest


public class AddActivityTest {

    @Rule
    public ActivityScenarioRule<AddActivity> addActivityActivityScenarioRule = new ActivityScenarioRule<AddActivity>(AddActivity.class);

    @Test
    public void testInput() {

        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test"));
        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("69"));
        pressBack();

    }

}