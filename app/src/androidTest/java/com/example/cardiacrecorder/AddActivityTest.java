package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
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

        onView(withId(R.id.aDateValue)).perform(ViewActions.typeText("12/10/2021"));
        onView(withId(R.id.aTimeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.aSystolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.aDiastolicValue)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.aHeartRateValue)).perform(ViewActions.typeText("69"));
        pressBack();
        onView(withId(R.id.aCommentValue)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();
        //pressBack();



      //  pressBack();
        //onView(withId(R.id.addActivity)).perform(swipeUp());
        onView(withId(R.id.saveButton)).perform(click());
        //onView(withId(R.id.main)).check(matches(isDisplayed()));

    }

}