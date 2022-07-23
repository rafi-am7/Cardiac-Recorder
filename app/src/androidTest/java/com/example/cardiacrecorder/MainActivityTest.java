package com.example.cardiacrecorder;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import static java.util.regex.Pattern.matches;

import android.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.action.ViewActions;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

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
        /*
        To update data
         */
        onView(withId(R.id.dateValue)).perform(ViewActions.typeText("12/10/2021"));
        onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("69"));
        pressBack();
        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();
        onView(withId(R.id.saveButton)).perform(click());




        /*
        To view data
         */
            // First scroll to the position that needs to be matched and click on it.
           onView(ViewMatchers.withId(R.id.rvRecords))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.backButton)).perform(click());


        /*
        To update data
         */
        // Match the text in an item below the fold and check that it's displayed.
        onView(withId(R.id.rvRecords)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, MyViewAction.clickChildViewWithId(R.id.editIm)));
        onView(withId(R.id.uDateValue)).perform(ViewActions.clearText());
        onView(withId(R.id.uDateValue)).perform(ViewActions.typeText("11/10/2021"));
        //onView(withId(R.id.uTimeValue)).perform(ViewActions.clearText());
        //onView(withId(R.id.uTimeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.uSystolicValue)).perform(ViewActions.clearText());
        onView(withId(R.id.uSystolicValue)).perform(ViewActions.typeText("110"));
        onView(withId(R.id.uDiastolicValue)).perform(ViewActions.clearText());
        onView(withId(R.id.uDiastolicValue)).perform(ViewActions.typeText("80"));
        pressBack();
        onView(withId(R.id.uHeartRateValue)).perform(ViewActions.clearText());
        onView(withId(R.id.uHeartRateValue)).perform(ViewActions.typeText("69"));
        pressBack();
        onView(withId(R.id.uCommentValue)).perform(ViewActions.clearText());
        onView(withId(R.id.uCommentValue)).perform(ViewActions.typeText("Updated"));
        pressBack();
        onView(withId(R.id.updateButton)).perform(click());

      /*
        To delete data ; delete shows unusal behaviors
        */
/*
        onView(withId(R.id.rvRecords)).perform(
                RecyclerViewActions.actionOnItemAtPosition(1, MyViewAction.clickChildViewWithId(R.id.deleteIm)));
*/


    }

}